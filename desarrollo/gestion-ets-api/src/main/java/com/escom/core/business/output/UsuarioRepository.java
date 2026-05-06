package com.escom.core.business.output;

import com.escom.core.entity.Materia;

import java.util.Optional;

public interface UsuarioRepository {

    Optional<Materia> findEtsById(Integer idEts,Integer idPersona);

    Optional<Materia> findEtsProximosAndFechaByIdPersona(Integer idPersona);
    void deleteEtsAgendaByIdEtsAgenda(Integer idEtsAgenda, Integer idPersona);
    boolean existsEtsAgendaByIdEtsAgenda(Integer idEtsAgenda);
}
