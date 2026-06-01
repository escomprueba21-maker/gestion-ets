package com.escom.external.jpa.dao;

import com.escom.core.business.output.PerfilRepository;
import com.escom.core.entity.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.Optional;
import java.util.stream.Stream;

@ApplicationScoped
public class PerfilDao implements PerfilRepository {

    private final EntityManager entityManager;

    @Inject
    public PerfilDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private static final String QUERY_FIND_PERFIL = """
            select esc02.id_persona, esc02.tx_nombre, esc02.tx_apellido_paterno,
            esc02.tx_apellido_materno, esc02.tx_correo, esc03.fk_id_rol
            from esc02_persona esc02
            join esc03_persona_rol esc03 on esc03.fk_id_persona = esc02.id_persona
            where esc02.id_persona = :idPersona and esc02.st_verificado is true
            """;

    private static final String QUERY_FIND_PASSWORD = """
            select esc02.id_persona, esc02.tx_password
            from esc02_persona esc02
            where esc02.id_persona = :idPersona
            """;

    private static final String QUERY_UPDATE_NOMBRE = """
            update esc02_persona
            set tx_nombre = :nombre,
                tx_apellido_paterno = :primerApellido,
                tx_apellido_materno = :segundoApellido
            where id_persona = :idPersona
            """;

    private static final String QUERY_UPDATE_PASSWORD = """
            update esc02_persona
            set tx_password = :password
            where id_persona = :idPersona
            """;

    private static final String PARAM_ID_PERSONA = "idPersona";
    private static final String PARAM_NOMBRE = "nombre";
    private static final String PARAM_PRIMER_APELLIDO = "primerApellido";
    private static final String PARAM_SEGUNDO_APELLIDO = "segundoApellido";
    private static final String PARAM_PASSWORD = "password";

    @Override
    @SuppressWarnings("unchecked")
    public Optional<Usuario> findPerfilByIdPersona(Integer idPersona) {
        Stream<Object[]> result = entityManager.createNativeQuery(QUERY_FIND_PERFIL)
                .setParameter(PARAM_ID_PERSONA, idPersona)
                .getResultStream();
        return result.findFirst().map(row -> Usuario.builder()
                .idUsuario((Integer) row[0])
                .nombre((String) row[1])
                .primerApellido((String) row[2])
                .segundoApellido((String) row[3])
                .email((String) row[4])
                .idRol((Integer) row[5])
                .build());
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<Usuario> findPasswordByIdPersona(Integer idPersona) {
        Stream<Object[]> result = entityManager.createNativeQuery(QUERY_FIND_PASSWORD)
                .setParameter(PARAM_ID_PERSONA, idPersona)
                .getResultStream();
        return result.findFirst().map(row -> Usuario.builder()
                .idUsuario((Integer) row[0])
                .password((String) row[1])
                .build());
    }

    @Override
    public void actualizarNombre(Integer idPersona, String nombre,
                                  String primerApellido, String segundoApellido) {
        entityManager.createNativeQuery(QUERY_UPDATE_NOMBRE)
                .setParameter(PARAM_NOMBRE, nombre)
                .setParameter(PARAM_PRIMER_APELLIDO, primerApellido)
                .setParameter(PARAM_SEGUNDO_APELLIDO, segundoApellido)
                .setParameter(PARAM_ID_PERSONA, idPersona)
                .executeUpdate();
    }

    @Override
    public void actualizarPassword(Integer idPersona, String password) {
        entityManager.createNativeQuery(QUERY_UPDATE_PASSWORD)
                .setParameter(PARAM_PASSWORD, password)
                .setParameter(PARAM_ID_PERSONA, idPersona)
                .executeUpdate();
    }
}
