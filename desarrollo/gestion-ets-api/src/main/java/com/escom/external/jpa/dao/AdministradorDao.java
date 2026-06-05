package com.escom.external.jpa.dao;

import com.escom.core.business.output.AdministradorRepository;
import com.escom.core.entity.Carrera;
import com.escom.core.entity.Materia;
import com.escom.core.entity.Periodo;
import com.escom.core.entity.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.stream.Stream;
import java.time.LocalDateTime;
import java.util.Optional;
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
        select count(*) from esc07_ets
        """;

private static final String QUERY_COUNT_CARRERAS = """
        select count(*) from cat01_carrera
        """;

private static final String QUERY_COUNT_SALONES = """
        select count(*) from esc06_aula
        """;

private static final String QUERY_COUNT_EXAMENES_POR_CARRERA = """
        select cat01.id_carrera, cat01.tx_nombre, count(esc07.id_ets) as total
        from cat01_carrera cat01
        left join esc01_carrera_materia esc01 on esc01.fk_id_carrera = cat01.id_carrera
        left join esc07_ets esc07 on esc07.fk_id_materia = esc01.fk_id_materia
        group by cat01.id_carrera, cat01.tx_nombre
        order by cat01.tx_nombre
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
    Stream<Object[]> result = entityManager.createNativeQuery(QUERY_COUNT_EXAMENES_POR_CARRERA)
            .getResultStream();
    return result.map(row -> Carrera.builder()
            .id((Integer) row[0])
            .nombre((String) row[1])
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
}
