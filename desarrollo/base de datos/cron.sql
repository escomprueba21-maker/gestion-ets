-- cron.sql
-- Jobs periódicos de limpieza con pg_cron

CREATE EXTENSION IF NOT EXISTS pg_cron;

-- Borra tokens expirados o ya usados
SELECT cron.schedule(
    'limpiar-tokens',
    '*/5 * * * *',
    $$ DELETE FROM esc04_token_confirmacion
       WHERE fh_expiracion < NOW() OR st_usado = true $$
);

-- Borra personas no verificadas cuyo token ya venció
SELECT cron.schedule(
    'limpiar-personas-no-verificadas',
    '*/5 * * * *',
    $$ DELETE FROM esc02_persona esc02
       WHERE esc02.st_verificado = false
         AND NOT EXISTS (
             SELECT 1 FROM esc04_token_confirmacion esc04
             WHERE esc04.fk_id_persona = esc02.id_persona
               AND esc04.fh_expiracion > NOW()
               AND esc04.st_usado = false
         ) $$
);

-- Consultar jobs activos: SELECT jobid, schedule, command FROM cron.job;
-- Consultar historial: SELECT * FROM cron.job_run_details ORDER BY start_time DESC LIMIT 10;
