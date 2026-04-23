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

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Stream;

@ApplicationScoped
public class UsuarioDao implements UsuarioRepository {

    private final EntityManager entityManager;

    private static final String QUERY_FIND_EXIST_USUARIO_BY_CORREO = """
            select exists(select 1 from esc02_persona esc02
            where esc02.tx_correo = :correo and esc02.st_verificado is true)
            """;
    private static final String QUERY_FIND_USUARIO_BY_TOKEN = """
            select esc04.fk_id_persona,esc04.fh_expiracion
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
                .fechaExpiracion((LocalDateTime) row[1])
                .build());
    }

    @Override
    public void saveRol(Usuario entity) {
        entityManager.persist(RolUsuarioJpa.fromEntity(entity));
    }

    @Override
    public void confirmarCuentaByIdPersona(Integer idPersona) {
        entityManager.createNativeQuery("""
            update esc02_persona
            set st_verificado = true
            where id_persona = :idPersona """)
                .setParameter(PARAM_ID_PERSONA, idPersona).executeUpdate();
    }

    @Override
    public void deleteToken(String token) {
        entityManager.createNativeQuery("""
        delete from esc04_token_confirmacion 
        where token = :token """).setParameter(PARAM_TOKEN,token).executeUpdate();
    }
}
