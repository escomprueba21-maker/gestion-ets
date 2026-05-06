package com.escom.core.business.input;

import com.escom.core.entity.Materia;
import com.escom.util.error.ErrorCodeEnum;
import io.vavr.control.Either;

public interface UsuarioService {

    Either<ErrorCodeEnum, Materia> getEtsById(Integer idEts, Integer idPersona);
    Either<ErrorCodeEnum, Materia>getEtsProximosAndFechaByIdPersona(Integer idPersona);
}
