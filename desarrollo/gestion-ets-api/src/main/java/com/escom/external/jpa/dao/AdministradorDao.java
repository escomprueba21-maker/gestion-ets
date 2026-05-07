package com.escom.external.jpa.dao;

import com.escom.core.business.output.AdministradorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

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

    private static final String PARAM_ID_ETS = "idEts";

    @Override
    public void deleteEtsById(Integer idEts) {
        entityManager.createNativeQuery("delete from esc07_ets where id_ets = :idEts ").setParameter(PARAM_ID_ETS,idEts).executeUpdate();
    }

    @Override
    public boolean existsEtsById(Integer idEts) {
        return (boolean) entityManager.createNativeQuery(QUERY_FIND_EXISTS_ETS).setParameter(PARAM_ID_ETS,idEts).getSingleResult();
    }
}
