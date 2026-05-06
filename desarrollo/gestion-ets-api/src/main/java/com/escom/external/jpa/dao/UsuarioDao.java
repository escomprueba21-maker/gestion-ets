package com.escom.external.jpa.dao;

import com.escom.core.business.output.UsuarioRepository;
import com.escom.core.entity.Materia;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.Optional;
import java.util.stream.Stream;


@ApplicationScoped
public class UsuarioDao implements UsuarioRepository {

    private final EntityManager entityManager;


    @Inject
    public UsuarioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private static final String QUERY_FIND_ETS_BY_ID = """
            select esc07.id_ets, cat02.tx_nombre as materia, concat(cat01.tx_clave, ' · Semestre ', esc01.nu_semestre) as plan,
            to_char(esc07.fh_aplicacion, 'dd/mm/yyyy') as fecha, concat (to_char(esc07.fh_aplicacion, 'hh24:mi'), ' hrs') as hora,
            cat05.tx_nombre as turno,
            concat( esc06.tx_clave ,' - ', esc06.tx_edificio) as salon,
            concat(esc05.tx_nombre, ' ', esc05.tx_apellido_paterno, ' ', coalesce(esc05.tx_apellido_materno, '')) as maestro,
            cat01.tx_clave as carrera,(esc08.id_agenda_ets is not null) as guardado
            from esc07_ets esc07
            join cat02_materia cat02 on cat02.id_materia = esc07.fk_id_materia
            join esc05_docente esc05 on esc05.id_docente = esc07.fk_id_docente
            join esc06_aula esc06 on esc06.id_aula = esc07.fk_id_aula
            join cat05_turno cat05 on cat05.id_turno= esc07.fk_id_turno
            join esc01_carrera_materia esc01 ON esc01.fk_id_materia = cat02.id_materia
            join cat01_carrera cat01 ON cat01.id_carrera = esc01.fk_id_carrera
            left join esc08_agenda_ets esc08 on esc08.fk_id_ets = esc07.id_ets and esc08.fk_id_persona = :idPersona
            where esc07.id_ets = :idEts
            """;

    private static final String QUERY_FIND_ETS_PROXIMOS_BY_ID = """
          with fecha_ets as(
          select
          concat(to_char(cat08.fh_inicio::date, 'DD/MM/YYYY'),' - ',
          to_char(cat08.fh_fin::date, 'DD/MM/YYYY')) as fecha,
          (cat08.fh_fin::date - cat08.fh_inicio::date) as duracion_periodo
          from cat08_periodo_ets cat08)
          select esc02.tx_nombre,coalesce(fe.fecha, 'Sin fechas') as fecha,
          coalesce(fe.duracion_periodo, 0) as duracion_dias,coalesce(json_agg(json_build_object('idEtsAgenda',esc08.id_agenda_ets,'idEts',esc07.id_ets,'materia',cat02.tx_nombre,
          'fechaHora',to_char(esc07.fh_aplicacion, 'dd/mm · HH24:MI'),'diasRestantes', (esc07.fh_aplicacion::date - current_date) )
          order by esc07.fh_aplicacion asc) filter (where esc08.id_agenda_ets is not null),'[]'::json)::text as agenda
          from esc02_persona esc02
          left join esc08_agenda_ets esc08 on esc08.fk_id_persona = esc02.id_persona
          left join esc07_ets esc07 on esc07.id_ets = esc08.fk_id_ets
          left join cat02_materia cat02 on cat02.id_materia = esc07.fk_id_materia
          left join lateral (select fecha,duracion_periodo from fecha_ets limit 1) fe on true
          where esc02.id_persona = :idPersona
          group by 1,2,3
          """;

    private static final String QUERY_FIND_EXISTS_ETS_AGENDA = """
            select exists(select 1 from esc08_agenda_ets esc08 where esc08.id_agenda_ets = :idEtsAgenda)
            """;


    private static final String PARAM_ID_ETS = "idEts";
    private static final String PARAM_ID_PERSONA = "idPersona";
    private static final String PARAM_ID_ETS_AGENDA = "idEtsAgenda";


    @Override
    @SuppressWarnings("unchecked")
    public Optional<Materia> findEtsById(Integer idEts, Integer idPersona) {
        Stream<Object[]>result = entityManager.createNativeQuery(QUERY_FIND_ETS_BY_ID)
                .setParameter(PARAM_ID_PERSONA, idPersona)
                .setParameter(PARAM_ID_ETS, idEts)
                .getResultStream();
        return result.findFirst().map(row->Materia.builder()
                .id((Integer)row[0])
                .nombre((String) row[1])
                .plan((String) row[2])
                .fecha((String) row[3])
                .hora((String) row[4])
                .turno((String) row[5])
                .salon((String) row[6])
                .docente((String) row[7])
                .carrera((String) row[8])
                .guardado((Boolean) row[9])
                .build());
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<Materia> findEtsProximosAndFechaByIdPersona(Integer idPersona) {
        Stream<Object[]>result = entityManager.createNativeQuery(QUERY_FIND_ETS_PROXIMOS_BY_ID)
                .setParameter(PARAM_ID_PERSONA,idPersona)
                .getResultStream();
        return result.findFirst().map(row->Materia.builder()
                .nombreUsuario((String) row[0])
                .fecha((String) row[1])
                .duracionDias((Integer) row[2])
                .jsEts((String) row[3])
                .build());
    }

    @Override
    public void deleteEtsAgendaByIdEtsAgenda(Integer idEtsAgenda,Integer idPersona) {
        entityManager.createQuery("delete from EtsAgendaJpa e where e.idAgendaEts = :idEtsAgenda and e.idPersona = :idPersona ")
                .setParameter(PARAM_ID_ETS_AGENDA, idEtsAgenda)
                .setParameter(PARAM_ID_PERSONA, idPersona)
                .executeUpdate();
    }

    @Override
    public boolean existsEtsAgendaByIdEtsAgenda(Integer idEtsAgenda) {
        return (boolean) entityManager.createNativeQuery(QUERY_FIND_EXISTS_ETS_AGENDA).setParameter(PARAM_ID_ETS_AGENDA,idEtsAgenda).getSingleResult();
    }
}