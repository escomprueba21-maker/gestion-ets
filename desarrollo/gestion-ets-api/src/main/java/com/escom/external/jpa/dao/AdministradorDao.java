package com.escom.external.jpa.dao;

import com.escom.core.business.output.AdministradorRepository;
import com.escom.core.entity.Carrera;
import com.escom.core.entity.Materia;
import com.escom.core.entity.Periodo;
import com.escom.core.entity.Usuario;
import com.escom.core.entity.Examen;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.stream.Stream;
import java.time.LocalDateTime;
import java.util.Optional;

import org.hibernate.query.TypedParameterValue;
import org.hibernate.type.StandardBasicTypes;
@ApplicationScoped
public class AdministradorDao implements AdministradorRepository {

    private final EntityManager entityManager;

    @Inject
    public AdministradorDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private static final String QUERY_FIND_EXISTS_ETS = """
            select exists (select 1 from esc07_ets esc07 where esc07.id_ets = :idEts)
            """;
    private static final String QUERY_FIND_ALUMNOS_JOIN_IN_ETS_BY_ID = """
            with ets as (
            select esc08.fk_id_persona from esc07_ets esc07
            join esc08_agenda_ets esc08 on esc08.fk_id_ets = esc07.id_ets
            where esc07.id_ets = :idEts
            )
            select esc02.id_persona,esc09.tx_fcm_token,esc02.tx_correo from esc02_persona esc02
            left join esc09_dispositivo esc09 on esc09.fk_id_persona = esc02.id_persona
            left join ets ets10 on ets10.fk_id_persona = esc02.id_persona
            """;

    private static final String QUERY_EXISTS_PERIODO = """
            select exists(select 1 from cat08_periodo_ets cat08 where now() > cat08.fh_fin )
            """;

    private static final String PARAM_ID_ETS = "idEts";

    private static final String QUERY_FIND_PERIODO_ACTUAL = """
        select cat08.id_periodo, cat08.tx_nombre, cat08.fh_inicio, cat08.fh_fin,
        cat08.fk_id_tipo_ets
        from cat08_periodo_ets cat08
        order by cat08.fh_inicio desc
        limit 1
        """;

private static final String QUERY_COUNT_EXAMENES = """
        SELECT COUNT(esc07.id_ets)
        FROM esc07_ets esc07
        JOIN (
            SELECT fh_inicio, fh_fin
            FROM cat08_periodo_ets
            ORDER BY fh_inicio DESC
            LIMIT 1
        ) periodo ON esc07.fh_aplicacion BETWEEN periodo.fh_inicio AND periodo.fh_fin
        """;

private static final String QUERY_COUNT_CARRERAS = """
        SELECT COUNT(DISTINCT esc01.fk_id_carrera)
        FROM esc07_ets esc07
        JOIN esc01_carrera_materia esc01 ON esc01.fk_id_materia = esc07.fk_id_materia
        JOIN (
            SELECT fh_inicio, fh_fin
            FROM cat08_periodo_ets
            ORDER BY fh_inicio DESC
            LIMIT 1
        ) periodo ON esc07.fh_aplicacion BETWEEN periodo.fh_inicio AND periodo.fh_fin
        """;

private static final String QUERY_COUNT_SALONES = """
        SELECT COUNT(DISTINCT esc07.fk_id_aula)
        FROM esc07_ets esc07
        JOIN (
            SELECT fh_inicio, fh_fin
            FROM cat08_periodo_ets
            ORDER BY fh_inicio DESC
            LIMIT 1
        ) periodo ON esc07.fh_aplicacion BETWEEN periodo.fh_inicio AND periodo.fh_fin
        """;

private static final String QUERY_COUNT_EXAMENES_POR_CARRERA = """
        SELECT cat01.id_carrera, cat01.tx_nombre, COUNT(esc07.id_ets) as total
        FROM cat01_carrera cat01
        LEFT JOIN esc01_carrera_materia esc01 ON esc01.fk_id_carrera = cat01.id_carrera
        LEFT JOIN esc07_ets esc07 ON esc07.fk_id_materia = esc01.fk_id_materia
        LEFT JOIN (
            SELECT id_periodo, fh_inicio, fh_fin
            FROM cat08_periodo_ets
            ORDER BY fh_inicio DESC
            LIMIT 1
        ) periodo ON esc07.fh_aplicacion BETWEEN periodo.fh_inicio AND periodo.fh_fin
        GROUP BY cat01.id_carrera, cat01.tx_nombre
        ORDER BY cat01.tx_nombre
        """;

private static final String QUERY_SAVE_PERIODO = """
        insert into cat08_periodo_ets (tx_nombre, fk_id_tipo_ets, fh_inicio, fh_fin)
        values (:nombre, :idTipoEts, :fechaInicio, :fechaFin)
        """;

private static final String QUERY_UPDATE_PERIODO = """
        update cat08_periodo_ets
        set tx_nombre = :nombre, fh_inicio = :fechaInicio, fh_fin = :fechaFin
        where id_periodo = :idPeriodo
        """;

private static final String QUERY_DELETE_PERIODO = """
        delete from cat08_periodo_ets where id_periodo = :idPeriodo
        """;

private static final String QUERY_EXISTS_ETS_EN_PERIODO = """
        select exists(
            select 1 from esc07_ets esc07
            join cat08_periodo_ets cat08 on esc07.fh_aplicacion between cat08.fh_inicio and cat08.fh_fin
            where cat08.id_periodo = :idPeriodo
        )
        """;

private static final String QUERY_COUNT_ETS_AFECTADOS = """
        select count(*) from esc07_ets esc07
        where esc07.fh_aplicacion < :fechaInicio or esc07.fh_aplicacion > :fechaFin
        """;

private static final String QUERY_COUNT_ETS_EN_PERIODO = """
        SELECT COUNT(esc07.id_ets)
        FROM esc07_ets esc07
        JOIN cat08_periodo_ets cat08
            ON esc07.fh_aplicacion BETWEEN cat08.fh_inicio AND cat08.fh_fin
        WHERE cat08.id_periodo = :idPeriodo
        """;

private static final String QUERY_FIND_EXAMENES_BY_FILTROS = """
        select esc07.id_ets, esc07.fk_id_materia, cat02.tx_nombre,
        esc07.fk_id_docente,
        concat(esc05.tx_nombre, ' ', esc05.tx_apellido_paterno, ' ', coalesce(esc05.tx_apellido_materno, '')),
        esc07.fk_id_aula, esc06.tx_clave,
        esc07.fk_id_turno, cat05.tx_nombre,
        esc07.fk_id_tipo_ets, esc07.fh_aplicacion
        from esc07_ets esc07
        join cat02_materia cat02 on cat02.id_materia = esc07.fk_id_materia
        join esc05_docente esc05 on esc05.id_docente = esc07.fk_id_docente
        join esc06_aula esc06 on esc06.id_aula = esc07.fk_id_aula
        join cat05_turno cat05 on cat05.id_turno = esc07.fk_id_turno
        where (:idTurno is null or esc07.fk_id_turno = :idTurno)
        and ((:idCarrera is null and :idSemestre is null)
            or exists (select 1 from esc01_carrera_materia esc01
                where esc01.fk_id_materia = cat02.id_materia
                and (:idCarrera is null or esc01.fk_id_carrera = :idCarrera)
                and (:idSemestre is null or esc01.nu_semestre = :idSemestre)))
        order by esc07.fh_aplicacion asc
        """;

private static final String QUERY_INSERT_EXAMEN = """
        insert into esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fk_id_tipo_ets, fh_aplicacion)
        values (:idMateria, :idDocente, :idAula, :idTurno, :idTipoEts, :fechaAplicacion)
        """;

private static final String QUERY_UPDATE_EXAMEN = """
        update esc07_ets
        set fk_id_materia = :idMateria, fk_id_docente = :idDocente, fk_id_aula = :idAula,
        fk_id_turno = :idTurno, fk_id_tipo_ets = :idTipoEts, fh_aplicacion = :fechaAplicacion
        where id_ets = :idEts
        """;

private static final String QUERY_EXISTS_CATALOGOS_EXAMEN = """
        select
        exists(select 1 from cat02_materia where id_materia = :idMateria)
        and exists(select 1 from esc05_docente where id_docente = :idDocente)
        and exists(select 1 from esc06_aula where id_aula = :idAula)
        and exists(select 1 from cat05_turno where id_turno = :idTurno)
        and exists(select 1 from cat06_tipo_ets where id_tipo_ets = :idTipoEts)
        """;

private static final String PARAM_ID_MATERIA = "idMateria";
private static final String PARAM_ID_DOCENTE = "idDocente";
private static final String PARAM_ID_AULA = "idAula";
private static final String PARAM_ID_TURNO = "idTurno";
private static final String PARAM_FECHA_APLICACION = "fechaAplicacion";
private static final String PARAM_ID_SEMESTRE = "idSemestre";
private static final String PARAM_ID_CARRERA = "idCarrera";

private static final String PARAM_ID_PERIODO = "idPeriodo";
private static final String PARAM_NOMBRE = "nombre";
private static final String PARAM_FECHA_INICIO = "fechaInicio";
private static final String PARAM_FECHA_FIN = "fechaFin";
private static final String PARAM_ID_TIPO_ETS = "idTipoEts";

    @Override
    public void deleteEtsById(Integer idEts) {
        entityManager.createNativeQuery("delete from esc08_agenda_ets where fk_id_ets = :idEts")
                .setParameter(PARAM_ID_ETS, idEts).executeUpdate();
        entityManager.createNativeQuery("delete from esc07_ets where id_ets = :idEts ")
                .setParameter(PARAM_ID_ETS,idEts).executeUpdate();
    }

    @Override
    public boolean existsEtsById(Integer idEts) {
        return (boolean) entityManager.createNativeQuery(QUERY_FIND_EXISTS_ETS).setParameter(PARAM_ID_ETS,idEts).getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Usuario> listEtsJoinUsuariosWithFcm(Integer idEts) {
        Stream<Object[]> result = entityManager.createNativeQuery(QUERY_FIND_ALUMNOS_JOIN_IN_ETS_BY_ID)
                .setParameter(PARAM_ID_ETS,idEts)
                .getResultStream();
        return result.map(row->Usuario.builder()
                .idUsuario((Integer)row[0])
                .fcmToken((String) row[1])
                .email((String) row[2])
                .build()).toList();
    }

    @Override
    public boolean existsPeriodo() {
        return (boolean) entityManager.createNativeQuery(QUERY_EXISTS_PERIODO).getSingleResult();
    }

    @Override
    public List<Materia> findSalonesByFiltros(String salon, Integer idEdificio, Integer idSalon) {
        return List.of();
    }

    @Override
@SuppressWarnings("unchecked")
public Optional<Periodo> findPeriodoActual() {
    Stream<Object[]> result = entityManager.createNativeQuery(QUERY_FIND_PERIODO_ACTUAL)
            .getResultStream();
    return result.findFirst().map(row -> Periodo.builder()
            .idPeriodo((Integer) row[0])
            .nombre((String) row[1])
            .fechaInicio((LocalDateTime) row[2])
            .fechaFin((LocalDateTime) row[3])
            .idTipoEts((Integer) row[4])
            .build());
}

@Override
public Integer countExamenes() {
    return ((Number) entityManager.createNativeQuery(QUERY_COUNT_EXAMENES)
            .getSingleResult()).intValue();
}

@Override
public Integer countCarreras() {
    return ((Number) entityManager.createNativeQuery(QUERY_COUNT_CARRERAS)
            .getSingleResult()).intValue();
}

@Override
public Integer countSalones() {
    return ((Number) entityManager.createNativeQuery(QUERY_COUNT_SALONES)
            .getSingleResult()).intValue();
}

@Override
@SuppressWarnings("unchecked")
public List<Carrera> countExamenesPorCarrera() {
        Stream<Object[]> result = entityManager
            .createNativeQuery(QUERY_COUNT_EXAMENES_POR_CARRERA)
            .getResultStream();
        return result.map(row -> Carrera.builder()
            .id((Integer) row[0])
            .nombre((String) row[1])
            .totalExamenes(((Number) row[2]).intValue())
            .build()).toList();
}

@Override
public void savePeriodo(Periodo periodo) {
    entityManager.createNativeQuery(QUERY_SAVE_PERIODO)
            .setParameter(PARAM_NOMBRE, periodo.getNombre())
            .setParameter(PARAM_ID_TIPO_ETS, periodo.getIdTipoEts())
            .setParameter(PARAM_FECHA_INICIO, periodo.getFechaInicio())
            .setParameter(PARAM_FECHA_FIN, periodo.getFechaFin())
            .executeUpdate();
}

@Override
public void updatePeriodo(Periodo periodo) {
    entityManager.createNativeQuery(QUERY_UPDATE_PERIODO)
            .setParameter(PARAM_NOMBRE, periodo.getNombre())
            .setParameter(PARAM_FECHA_INICIO, periodo.getFechaInicio())
            .setParameter(PARAM_FECHA_FIN, periodo.getFechaFin())
            .setParameter(PARAM_ID_PERIODO, periodo.getIdPeriodo())
            .executeUpdate();
}

@Override
public void deletePeriodo(Integer idPeriodo) {
    entityManager.createNativeQuery(QUERY_DELETE_PERIODO)
            .setParameter(PARAM_ID_PERIODO, idPeriodo)
            .executeUpdate();
}

@Override
public boolean existsEtsEnPeriodo(Integer idPeriodo) {
    return (boolean) entityManager.createNativeQuery(QUERY_EXISTS_ETS_EN_PERIODO)
            .setParameter(PARAM_ID_PERIODO, idPeriodo)
            .getSingleResult();
}

@Override
public Integer countEtsAfectadosByFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
    return ((Number) entityManager.createNativeQuery(QUERY_COUNT_ETS_AFECTADOS)
            .setParameter(PARAM_FECHA_INICIO, fechaInicio)
            .setParameter(PARAM_FECHA_FIN, fechaFin)
            .getSingleResult()).intValue();
}

@Override
public Integer countEtsEnPeriodo(Integer idPeriodo) {
    return ((Number) entityManager.createNativeQuery(QUERY_COUNT_ETS_EN_PERIODO)
            .setParameter(PARAM_ID_PERIODO, idPeriodo)
            .getSingleResult()).intValue();
}

@Override
@SuppressWarnings("unchecked")
public List<Examen> findExamenesByFiltros(Integer idCarrera, Integer idTurno, Integer idSemestre) {
    Stream<Object[]> result = entityManager.createNativeQuery(QUERY_FIND_EXAMENES_BY_FILTROS)
            .setParameter(PARAM_ID_CARRERA, new TypedParameterValue<>(StandardBasicTypes.INTEGER, idCarrera))
            .setParameter(PARAM_ID_TURNO, new TypedParameterValue<>(StandardBasicTypes.INTEGER, idTurno))
            .setParameter(PARAM_ID_SEMESTRE, new TypedParameterValue<>(StandardBasicTypes.INTEGER, idSemestre))
            .getResultStream();
    return result.map(row -> Examen.builder()
            .idEts((Integer) row[0])
            .idMateria((Integer) row[1])
            .nombreMateria((String) row[2])
            .idDocente((Integer) row[3])
            .nombreDocente((String) row[4])
            .idAula((Integer) row[5])
            .claveAula((String) row[6])
            .idTurno((Integer) row[7])
            .nombreTurno((String) row[8])
            .idTipoEts((Integer) row[9])
            .fechaAplicacion((LocalDateTime) row[10])
            .build()).toList();
}

@Override
public void createExamen(Examen examen) {
    entityManager.createNativeQuery(QUERY_INSERT_EXAMEN)
            .setParameter(PARAM_ID_MATERIA, examen.getIdMateria())
            .setParameter(PARAM_ID_DOCENTE, examen.getIdDocente())
            .setParameter(PARAM_ID_AULA, examen.getIdAula())
            .setParameter(PARAM_ID_TURNO, examen.getIdTurno())
            .setParameter(PARAM_ID_TIPO_ETS, examen.getIdTipoEts())
            .setParameter(PARAM_FECHA_APLICACION, examen.getFechaAplicacion())
            .executeUpdate();
}

@Override
public void updateExamen(Examen examen) {
    entityManager.createNativeQuery(QUERY_UPDATE_EXAMEN)
            .setParameter(PARAM_ID_MATERIA, examen.getIdMateria())
            .setParameter(PARAM_ID_DOCENTE, examen.getIdDocente())
            .setParameter(PARAM_ID_AULA, examen.getIdAula())
            .setParameter(PARAM_ID_TURNO, examen.getIdTurno())
            .setParameter(PARAM_ID_TIPO_ETS, examen.getIdTipoEts())
            .setParameter(PARAM_FECHA_APLICACION, examen.getFechaAplicacion())
            .setParameter(PARAM_ID_ETS, examen.getIdEts())
            .executeUpdate();
}

@Override
public boolean existsCatalogosExamen(Examen examen) {
    return (boolean) entityManager.createNativeQuery(QUERY_EXISTS_CATALOGOS_EXAMEN)
            .setParameter(PARAM_ID_MATERIA, examen.getIdMateria())
            .setParameter(PARAM_ID_DOCENTE, examen.getIdDocente())
            .setParameter(PARAM_ID_AULA, examen.getIdAula())
            .setParameter(PARAM_ID_TURNO, examen.getIdTurno())
            .setParameter(PARAM_ID_TIPO_ETS, examen.getIdTipoEts())
            .getSingleResult();
}
}
