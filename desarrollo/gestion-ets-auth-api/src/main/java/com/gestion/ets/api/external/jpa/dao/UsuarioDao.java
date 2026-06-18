package com.gestion.ets.api.external.jpa.dao;

import com.gestion.ets.api.core.business.output.UsuarioRepository;
import com.gestion.ets.api.core.entity.Auth;
import com.gestion.ets.api.core.entity.Dispositivo;
import com.gestion.ets.api.core.entity.Usuario;
import com.gestion.ets.api.external.jpa.model.AuthJpa;
import com.gestion.ets.api.external.jpa.model.DispositivoJpa;
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

    @Inject
    public UsuarioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    private static final String QUERY_FIND_USUARIO_BY_TOKEN = """
            select esc04.fk_id_persona, esc04.fh_expiracion
            from esc04_token_confirmacion esc04
            where esc04.token = :token
            """;
    private static final String QUERY_FIND_USUARIO_BY_EMAIL = """
        select esc02.id_persona, esc02.tx_nombre, esc02.tx_apellido_paterno,esc02.tx_apellido_materno,
        esc02.st_verificado from esc02_persona esc02
        where esc02.tx_correo = :correo
        """;
    private static final String QUERY_FIND_USUARIO_VERIFY_BY_EMAIL = """
        select esc02.id_persona, esc03.fk_id_rol,esc02.tx_password, concat(esc02.tx_nombre, ' ', esc02.tx_apellido_paterno,
        coalesce(concat(' ', esc02.tx_apellido_materno), ''))
        as nombre_completo from esc02_persona esc02
        join esc03_persona_rol esc03 on esc03.fk_id_persona = esc02.id_persona
        where esc02.tx_correo = :correo and esc02.st_verificado is true
        """;

    private static final String QUERY_DELETE_TOKEN_BY_ID_PERSONA = """
        delete from esc04_token_confirmacion
        where fk_id_persona = :idPersona
        """;

    private static final String QUERY_UPDATE_DATOS_NO_VERIFICADO = """
        update esc02_persona
        set tx_nombre = :nombre,
            tx_apellido_paterno = :primerApellido,
            tx_apellido_materno = :segundoApellido,
            tx_password = :password
        where id_persona = :idPersona
        """;

    private static final String QUERY_UPDATE_PASSWORD = """
    update esc02_persona
    set tx_password = :password
    where id_persona = :idPersona
    """;

    private static final String QUERY_FIND_USUARIO_BY_ID = """
    select esc02.id_persona, esc03.fk_id_rol from esc02_persona esc02
    join esc03_persona_rol esc03 on esc03.fk_id_persona = esc02.id_persona
    where esc02.id_persona = :idPersona and esc02.st_verificado is true
    """;
    private static final String QUERY_FIND_EXISTS_FCM = """
            select exists( select 1 from esc09_dispositivo esc09
            where esc09.fk_id_persona = :idPersona
            and esc09.tx_fcm_token = :fcm)
            """;


    private static final String PARAM_CORREO = "correo";
    private static final String PARAM_TOKEN = "token";
    private static final String PARAM_ID_PERSONA = "idPersona";
    private static final String PARAM_NOMBRE = "nombre";
    private static final String PARAM_PRIMER_APELLIDO = "primerApellido";
    private static final String PARAM_SEGUNDO_APELLIDO = "segundoApellido";
    private static final String PARAM_PASSWORD = "password";
    private static final String PARAM_FCM = "fcm";



    @Override
    public Usuario Save(Usuario entity) {
        return entityManager.merge(UsuarioJpa.fromEntity(entity)).toEntity();
    }

    @Override
    public void createAuthUsuario(Auth entity) {
        entityManager.persist(AuthJpa.fromEntity(entity));
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<Usuario> findByToken(String token) {
        Stream<Object[]> result = entityManager.createNativeQuery(QUERY_FIND_USUARIO_BY_TOKEN)
                .setParameter(PARAM_TOKEN, token).getResultStream();
        return result.findFirst().map(row -> Usuario.builder()
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
                where token = :token """)
                .setParameter(PARAM_TOKEN, token).executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<Usuario> findByEmail(String email) {
        Stream<Object[]> result = entityManager.createNativeQuery(QUERY_FIND_USUARIO_BY_EMAIL)
                .setParameter(PARAM_CORREO, email).getResultStream();
        return result.findFirst().map(row -> Usuario.builder()
                .idUsuario((Integer) row[0])
                .nombre((String) row[1])
                .primerApellido((String) row[2])
                .segundoApellido((String) row[3])
                .verificado((Boolean) row[4])
                .build());
    }

    @Override
    public void deleteTokenByIdPersona(Integer idPersona) {
        entityManager.createNativeQuery(QUERY_DELETE_TOKEN_BY_ID_PERSONA)
                .setParameter(PARAM_ID_PERSONA, idPersona).executeUpdate();
    }

    @Override
    public void updateDatosNoVerificado(Usuario entity) {
        entityManager.createNativeQuery(QUERY_UPDATE_DATOS_NO_VERIFICADO)
                .setParameter(PARAM_NOMBRE, entity.getNombre())
                .setParameter(PARAM_PRIMER_APELLIDO, entity.getPrimerApellido())
                .setParameter(PARAM_SEGUNDO_APELLIDO, entity.getSegundoApellido())
                .setParameter(PARAM_PASSWORD, entity.getPassword())
                .setParameter(PARAM_ID_PERSONA, entity.getIdUsuario())
                .executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<Usuario> findPersonaVerifyByEmail(String email) {
        Stream<Object[]> result = entityManager.createNativeQuery(QUERY_FIND_USUARIO_VERIFY_BY_EMAIL)
                .setParameter(PARAM_CORREO, email).getResultStream();
        return result.findFirst().map(row -> Usuario.builder()
                .idUsuario((Integer) row[0])
                .idRol((Integer) row[1])
                .password((String) row[2])
                .nombre((String) row[3])
                .build());
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<Usuario> findById(Integer idPersona) {
        Stream<Object[]> result = entityManager.createNativeQuery(QUERY_FIND_USUARIO_BY_ID)
                .setParameter(PARAM_ID_PERSONA, idPersona).getResultStream();
        return result.findFirst().map(row -> Usuario.builder()
                .idUsuario((Integer) row[0])
                .idRol((Integer) row[1])
                .build());
    }

    @Override
    public void actualizarPassword(Integer idPersona, String password) {
        entityManager.createNativeQuery(QUERY_UPDATE_PASSWORD)
                .setParameter(PARAM_PASSWORD,password)
                .setParameter(PARAM_ID_PERSONA, idPersona)
                .executeUpdate();
    }

    @Override
    public void saveFcm(Dispositivo entity) {
        entityManager.persist(DispositivoJpa.fromEntity(entity));
    }

    @Override
    public boolean existsFcm(Integer idPersona, String fcm) {
        return (boolean) entityManager.createNativeQuery(QUERY_FIND_EXISTS_FCM)
                .setParameter(PARAM_ID_PERSONA,idPersona)
                .setParameter(PARAM_FCM, fcm)
                .getSingleResult();
    }
}