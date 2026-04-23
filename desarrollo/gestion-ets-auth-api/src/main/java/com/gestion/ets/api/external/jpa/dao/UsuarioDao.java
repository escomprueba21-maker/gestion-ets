package com.gestion.ets.api.external.jpa.dao;

import com.gestion.ets.api.core.business.output.UsuarioRepository;
import com.gestion.ets.api.core.entity.Auth;
import com.gestion.ets.api.core.entity.Usuario;
import com.gestion.ets.api.external.jpa.model.AuthJpa;
import com.gestion.ets.api.external.jpa.model.RolUsuarioJpa;
import com.gestion.ets.api.external.jpa.model.UsuarioJpa;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Stream;

@ApplicationScoped
public class UsuarioDao implements UsuarioRepository {

    private final EntityManager entityManager;

    private static final String QUERY_FIND_EXIST_USUARIO_BY_CORREO = """
            select exists(select 1 from esc02_persona esc02
            where esc02.tx_correo = :correo)
            """;
    private static final String QUERY_FIND_USUARIO_BY_TOKEN = """
            select esc04.fk_id_persona,esc04.st_usado,esc04.fh_expiracion
            from esc04_token_confirmacion esc04
            where esc04.token = :token
            """;

    private static final String PARAM_CORREO = "correo";
    private static final String PARAM_TOKEN = "token";
    private static final String PARAM_ID_PERSONA = "idPersona";

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

    @Override
    @SuppressWarnings("unchecked")
    public Optional<Usuario> findByToken(String token) {
        Stream<Object[]>result = entityManager.createNativeQuery(QUERY_FIND_USUARIO_BY_TOKEN)
                .setParameter(PARAM_TOKEN, token).getResultStream();
        return result.findFirst().map(row->Usuario.builder()
                .idUsuario((Integer) row[0])
                .tokenUsado((Boolean) row[1])
                .fechaExpiracion((LocalDateTime) row[2])
                .build());
    }

    @Override
    public void saveRol(Usuario entity) {
        entityManager.persist(RolUsuarioJpa.fromEntity(entity));
    }

    @Override
    public void confirmarCuentaByTokenAndIdPersona(String token, Integer idPersona) {
        entityManager.createNativeQuery("""
            update esc04_token_confirmacion
            set st_usado = true where token = :token """)
                .setParameter(PARAM_TOKEN, token) .executeUpdate();

        entityManager.createNativeQuery("""
            update esc02_persona
            set st_verificado = true
            where id_persona = :idPersona """)
                .setParameter(PARAM_ID_PERSONA, idPersona).executeUpdate();
    }
}
