package com.escom.core.business.input;

import com.escom.core.entity.Usuario;
import com.escom.util.error.ErrorCodeEnum;
import io.vavr.control.Either;

public interface PerfilService {
    Either<ErrorCodeEnum, Usuario> getPerfil(Integer idPersona);
    Either<ErrorCodeEnum, Boolean> actualizarNombre(Integer idPersona, String nombre,
                                                     String primerApellido, String segundoApellido);
    Either<ErrorCodeEnum, Boolean> cambiarPassword(Integer idPersona, String passwordActual,
                                                    String passwordNueva, String passwordConfirmacion);
}
