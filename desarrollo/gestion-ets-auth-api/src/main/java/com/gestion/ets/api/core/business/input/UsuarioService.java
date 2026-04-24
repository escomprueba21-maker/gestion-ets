package com.gestion.ets.api.core.business.input;

import com.gestion.ets.api.core.entity.Usuario;
import com.gestion.ets.api.util.error.ErrorCodeEnum;
import io.vavr.control.Either;

public interface UsuarioService {

    /**
     * Crea un usuario
     * @param entity entidad de tipo {@link Usuario}
     * @return si se persiste regresa true, si hay un problema regresa un Error code
     */
    Either<ErrorCodeEnum,Boolean> createUsuario(Usuario entity);

    Either<ErrorCodeEnum,Boolean> verificarUsuarioByToken(String token);

    Either<ErrorCodeEnum, Boolean> reenviarConfirmacion(String email);
}
