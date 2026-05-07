package com.escom.core.business.implementation;

import com.escom.core.business.input.FirebaseService;
import com.escom.core.business.input.UsuarioService;
import com.escom.core.business.output.UsuarioRepository;
import com.escom.core.entity.Ets;
import com.escom.core.entity.Materia;
import com.escom.util.JsonMapperUtils;
import com.escom.util.error.ErrorCodeEnum;
import io.vavr.control.Either;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
public class UsuarioBs implements UsuarioService {


    private final UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioBs(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Either<ErrorCodeEnum, Materia> getEtsById(Integer idEts,Integer idPersona) {
         var searchEts = usuarioRepository.findEtsById(idEts,idPersona);
        return searchEts.<Either<ErrorCodeEnum, Materia>>map(Either::right).orElseGet(() -> Either.left(ErrorCodeEnum.GE_NOT_FOUND));
    }

    @Override
    public Either<ErrorCodeEnum, Materia> getEtsProximosAndFecha(Integer idPersona) {
        var searchEtsProximos = usuarioRepository.findEtsProximosAndFechaByIdPersona(idPersona);
        if (searchEtsProximos.isEmpty()) {
            return Either.left(ErrorCodeEnum.GE_NOT_FOUND);
        }
        var json = JsonMapperUtils.toList(searchEtsProximos.get().getJsEts(),Ets.class);
        searchEtsProximos.get().setEts(json);
        return Either.right(searchEtsProximos.get());
    }

    @Override
    @Transactional
    public Either<ErrorCodeEnum, Boolean> deleteEtsAgendaById(Integer idEtsAgenda,Integer idPersona) {
        if(!usuarioRepository.existsEtsAgendaByIdEtsAgenda(idEtsAgenda)) {
            return Either.left(ErrorCodeEnum.GE_NOT_FOUND);
        }
        usuarioRepository.deleteEtsAgendaByIdEtsAgenda(idEtsAgenda,idPersona);
        return Either.right(true);
    }
}