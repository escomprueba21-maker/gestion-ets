package com.escom.core.business.input;

import com.escom.core.entity.Materia;
import com.escom.util.error.ErrorCodeEnum;
import io.vavr.control.Either;

public interface UsuarioService {

    Either<ErrorCodeEnum, Materia> getEtsById(Integer idEts, Integer idPersona);
    Either<ErrorCodeEnum, Materia> getEtsProximosAndFecha(Integer idPersona);
    Either<ErrorCodeEnum,Boolean>deleteEtsAgendaById(Integer idEtsAgenda,Integer idPersona);
}
