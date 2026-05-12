package com.escom.core.business.implementation;


import com.escom.core.business.input.AdministradorService;
import com.escom.core.business.output.AdministradorRepository;
import com.escom.core.business.output.UsuarioRepository;
import com.escom.core.entity.Materia;
import com.escom.util.error.ErrorCodeEnum;
import io.vavr.control.Either;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class AdministradorBs implements AdministradorService {

    private final AdministradorRepository administradorRepository;
    private final UsuarioRepository usuarioRepository;

    @Inject
    public AdministradorBs(AdministradorRepository administradorRepository, UsuarioRepository usuarioRepository) {
        this.administradorRepository = administradorRepository;
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    @Transactional
    public Either<ErrorCodeEnum, Boolean> deleteEtsById(Integer idEts) {
        if(!administradorRepository.existsEtsById(idEts)) {
            return Either.left(ErrorCodeEnum.GE_NOT_FOUND);
        }
        if(administradorRepository.existsPeriodo()){
            return Either.left(ErrorCodeEnum.GE_RNS004);
        }
        //TODO: enviar msj app con fcm
        var listPersonasInEts = administradorRepository.listEtsJoinUsuariosWithFcm(idEts);
        administradorRepository.deleteEtsById(idEts);

        return Either.right(true);
    }

    @Override
    public List<Materia> listSalonesByFiltros(String salon, Integer idEdificio, Integer idSalon) {
        return List.of();
    }
}
