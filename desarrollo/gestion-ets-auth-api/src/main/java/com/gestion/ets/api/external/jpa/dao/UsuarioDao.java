package com.gestion.ets.api.external.jpa.dao;

import com.gestion.ets.api.core.business.output.UsuarioRepository;
import com.gestion.ets.api.core.entity.Auth;
import com.gestion.ets.api.core.entity.Usuario;
import com.gestion.ets.api.external.jpa.model.AuthJpa;
import com.gestion.ets.api.external.jpa.model.UsuarioJpa;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class UsuarioDao implements UsuarioRepository {

    private final EntityManager entityManager;

    private static final String QUERY_FIND_EXIST_USUARIO_BY_CORREO = """
            select exists(select 1 from esc02_persona esc02
            where esc02.tx_correo = :correo)
            """;

    private static final String PARAM_CORREO = "correo";

    @Inject
    public UsuarioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Usuario Save(Usuario entity) {
        return entityManager.merge(UsuarioJpa.fromEntity(entity)).toEntity();
    }

    @Override
    public boolean existUsuarioByCorreo(String email) {
        return (boolean) entityManager.createNativeQuery(QUERY_FIND_EXIST_USUARIO_BY_CORREO)
                .setParameter(PARAM_CORREO, email).getSingleResult();
    }

    @Override
    public void createAuthUsuario(Auth entity) {
        entityManager.persist(AuthJpa.fromEntity(entity));
    }
}
