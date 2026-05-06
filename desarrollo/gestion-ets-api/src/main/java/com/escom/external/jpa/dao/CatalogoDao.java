package com.escom.external.jpa.dao;

import com.escom.core.business.output.CatalogoRepository;
import com.escom.core.entity.Carrera;
import com.escom.core.entity.Materia;
import com.escom.core.entity.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.hibernate.query.TypedParameterValue;
import org.hibernate.type.StandardBasicTypes;

import java.util.List;
import java.util.stream.Stream;

@ApplicationScoped
public class CatalogoDao implements CatalogoRepository {

    private final EntityManager entityManager;

    @Inject
    public CatalogoDao( EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private final static String QUERY_FIND_ALL_CARRERAS = """
           select cat01.id_carrera, cat01.tx_clave from cat01_carrera cat01 
           """;

    private static final String QUERY_FIND_ETS_BY_ID_CARRERA_AND_ID_SEMESTRE_AND_NOMBRE = """
            select esc07.id_ets, cat02.tx_nombre as materia,concat(esc05.tx_nombre, ' ', esc05.tx_apellido_paterno, ' ', coalesce(esc05.tx_apellido_materno, '')) as maestro,
            concat(to_char(esc07.fh_aplicacion, 'dd/mm'), ' · ', cat05.tx_nombre, ' · ', to_char(esc07.fh_aplicacion, 'hh24:mi')) as fecha,
            concat('Salón ', esc06.tx_clave) as salon
            from esc07_ets esc07
            join cat02_materia cat02 on cat02.id_materia = esc07.fk_id_materia
            join esc05_docente esc05 on esc05.id_docente = esc07.fk_id_docente
            join esc06_aula esc06 on esc06.id_aula = esc07.fk_id_aula
            join cat05_turno   cat05 on cat05.id_turno= esc07.fk_id_turno
            where ((:idCarrera is null and :idSemestre is null)
            or exists (select 1 from esc01_carrera_materia esc01
            where esc01.fk_id_materia = cat02.id_materia
            and (:idCarrera  is null or esc01.fk_id_carrera = :idCarrera)
            and (:idSemestre is null or esc01.nu_semestre   = :idSemestre)))
            and (:nombre is null or unaccent(cat02.tx_nombre) ilike unaccent('%' || :nombre || '%'))
            order by esc07.fh_aplicacion asc;
            """;

    private static final String QUERY_FIND_ALL_DOCENTES = """
            select esc05.id_docente,
            concat(esc05.tx_nombre, ' ', esc05.tx_apellido_paterno, ' ', esc05.tx_apellido_materno )
            from esc05_docente esc05
            """;

    private static final String QUERY_FIND_MATERIAS_BY_ID_CARRERA_AND_ID_SEMESTRE = """
            select cat02.id_materia, cat02.tx_nombre from esc01_carrera_materia esc01
            join cat02_materia cat02 on cat02.id_materia = esc01.fk_id_materia
            where esc01.fk_id_carrera = :idCarrera and esc01.nu_semestre = :idSemestre
            """;



    private static final String PARAM_ID_CARRERA = "idCarrera";
    private static final String PARAM_ID_SEMESTRE = "idSemestre";
    private static final String PARAM_NOMBRE = "nombre";


    @Override
    @SuppressWarnings("unchecked")
    public List<Carrera> findAllCarreras() {
        Stream<Object[]> result = entityManager.createNativeQuery(QUERY_FIND_ALL_CARRERAS)
                .getResultStream();
        return result.map(row->Carrera.builder()
                .id((Integer) row[0])
                .nombre((String) row[1])
                .build()).toList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Materia> findEtsByIdCarreraAndIdSemestre(Integer idCarrera, Integer idSemestre, String materia) {
        Stream<Object[]> result = entityManager.createNativeQuery(QUERY_FIND_ETS_BY_ID_CARRERA_AND_ID_SEMESTRE_AND_NOMBRE)
                .setParameter(PARAM_ID_CARRERA, new TypedParameterValue<>(StandardBasicTypes.INTEGER, idCarrera))
                .setParameter(PARAM_ID_SEMESTRE, new TypedParameterValue<>(StandardBasicTypes.INTEGER, idSemestre))
                .setParameter(PARAM_NOMBRE,new TypedParameterValue<>(StandardBasicTypes.STRING, materia))
                .getResultStream();
        return result.map(row->Materia.builder()
                .id((Integer) row[0])
                .nombre((String) row[1])
                .docente((String)row[2])
                .fechaTurno((String)row[3])
                .salon((String)row[4])
                .build()).toList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Materia> findMateriasByIdCarreraAndIdSemestre(Integer idCarrera, Integer idSemestre) {
        Stream<Object[]>result = entityManager.createNativeQuery(QUERY_FIND_MATERIAS_BY_ID_CARRERA_AND_ID_SEMESTRE)
                .setParameter(PARAM_ID_CARRERA,idCarrera)
                .setParameter(PARAM_ID_SEMESTRE,idSemestre)
                .getResultStream();
        return result.map(row->Materia.builder()
                .id((Integer) row[0])
                .nombre((String) row[1])
                .build()).toList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Usuario> findAllDocentes() {
        Stream<Object[]>result = entityManager.createNativeQuery(QUERY_FIND_ALL_DOCENTES).getResultStream();
        return result.map(row->Usuario.builder()
                .idUsuario((Integer) row[0])
                .nombre((String) row[1])
                .build()).toList();
    }


}
