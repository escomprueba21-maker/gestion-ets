package com.escom.core.business.implementation;

import com.escom.core.business.input.PerfilService;
import com.escom.core.business.output.PerfilRepository;
import com.escom.core.entity.Usuario;
import com.escom.util.error.ErrorCodeEnum;
import io.vavr.control.Either;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.mindrot.jbcrypt.BCrypt;

@ApplicationScoped
public class PerfilBs implements PerfilService {

    private final PerfilRepository perfilRepository;

    @Inject
    public PerfilBs(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @Override
    public Either<ErrorCodeEnum, Usuario> getPerfil(Integer idPersona) {
        var perfil = perfilRepository.findPerfilByIdPersona(idPersona);
        if (perfil.isEmpty()) {
            return Either.left(ErrorCodeEnum.GE_RNN002);
        }
        return Either.right(perfil.get());
    }

    @Override
    @Transactional
    public Either<ErrorCodeEnum, Boolean> actualizarNombre(Integer idPersona, String nombre,
                                                            String primerApellido, String segundoApellido) {
        if (perfilRepository.findPerfilByIdPersona(idPersona).isEmpty()) {
            return Either.left(ErrorCodeEnum.GE_RNN002);
        }
        perfilRepository.actualizarNombre(idPersona, nombre, primerApellido, segundoApellido);
        return Either.right(true);
    }

    @Override
    @Transactional
    public Either<ErrorCodeEnum, Boolean> cambiarPassword(Integer idPersona, String passwordActual,
                                                           String passwordNueva, String passwordConfirmacion) {
        var usuario = perfilRepository.findPasswordByIdPersona(idPersona);
        if (usuario.isEmpty()) {
            return Either.left(ErrorCodeEnum.GE_RNN002);
        }
        if (!BCrypt.checkpw(passwordActual, usuario.get().getPassword())) {
            return Either.left(ErrorCodeEnum.GE_RNN005);
        }
        if (!passwordNueva.equals(passwordConfirmacion)) {
            return Either.left(ErrorCodeEnum.GE_RNN006);
        }
        String nuevaHasheada = BCrypt.hashpw(passwordNueva, BCrypt.gensalt());
        perfilRepository.actualizarPassword(idPersona, nuevaHasheada);
        return Either.right(true);
    }
}