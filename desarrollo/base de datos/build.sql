-- =========================================================
-- build.sql
-- Script maestro: tira y recrea la base de datos
-- =========================================================

SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE datname='calendario-ets';
DROP DATABASE IF EXISTS "calendario-ets";
CREATE DATABASE "calendario-ets";

\c "calendario-ets"

BEGIN;
\i create.sql
\i catalogos.sql
\i ets_demo.sql
COMMIT;
