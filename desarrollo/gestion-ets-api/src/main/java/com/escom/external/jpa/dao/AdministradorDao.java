package com.escom.external.jpa.dao;

import com.escom.core.business.output.AdministradorRepository;
import com.escom.core.entity.Materia;
import com.escom.core.entity.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.stream.Stream;

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
}
