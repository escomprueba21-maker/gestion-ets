package com.escom.core.business.implementation;


import com.escom.core.business.input.AdministradorService;
import com.escom.core.business.output.AdministradorRepository;
import com.escom.util.error.ErrorCodeEnum;
import io.vavr.control.Either;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AdministradorBs implements AdministradorService {

    private final AdministradorRepository administradorRepository;

    @Inject
    public AdministradorBs(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }


    @Override
    public Either<ErrorCodeEnum, Boolean> deleteEtsById(Integer idEts) {
        if(!administradorRepository.existsEtsById(idEts)) {
            return Either.left(ErrorCodeEnum.GE_NOT_FOUND);
        }
        administradorRepository.deleteEtsById(idEts);
        return Either.right(true);
    }
}
