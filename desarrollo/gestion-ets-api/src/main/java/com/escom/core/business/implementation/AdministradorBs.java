package com.escom.core.business.implementation;


import com.escom.core.business.input.AdministradorService;
import com.escom.core.business.output.AdministradorRepository;
import com.escom.core.business.output.UsuarioRepository;
import com.escom.core.entity.Materia;
import com.escom.util.BsConstants;
import com.escom.util.error.ErrorCodeEnum;
import com.escom.core.entity.Periodo;
import com.escom.external.rest.dto.CarreraDashboardDTO;
import com.escom.external.rest.dto.DashboardDTO;
import com.escom.external.rest.dto.PeriodoDTO;

import io.vavr.control.Either;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.time.LocalDateTime;

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

@Override
public Either<ErrorCodeEnum, DashboardDTO> getDashboard() {
    var periodo = administradorRepository.findPeriodoActual();
    var totalExamenes = administradorRepository.countExamenes();
    var totalCarreras = administradorRepository.countCarreras();
    var totalSalones = administradorRepository.countSalones();
    var examenesPorCarrera = administradorRepository.countExamenesPorCarrera()
            .stream()
            .map(CarreraDashboardDTO::fromEntity)
            .toList();

    PeriodoDTO periodoDTO = null;
    if (periodo.isPresent()) {
        var p = periodo.get();
        var ahora = LocalDateTime.now(BsConstants.DEFAULT_ZONE_ID);
        boolean yaComenzo = ahora.isAfter(p.getFechaInicio());
        periodoDTO = PeriodoDTO.fromEntity(Periodo.builder()
                .idPeriodo(p.getIdPeriodo())
                .nombre(p.getNombre())
                .fechaInicio(p.getFechaInicio())
                .fechaFin(p.getFechaFin())
                .periodoYaComenzo(yaComenzo)
                .examenesAfectados(0)
                .build());
    }

    return Either.right(DashboardDTO.fromEntity(
            periodoDTO, totalExamenes, totalCarreras, totalSalones, examenesPorCarrera));
}

@Override
@Transactional
public Either<ErrorCodeEnum, Boolean> asignarPeriodo(Periodo periodo) {
    var periodoActual = administradorRepository.findPeriodoActual();
    if (periodoActual.isPresent()) {
        return Either.left(ErrorCodeEnum.GE_RNS008);
    }

    administradorRepository.savePeriodo(periodo);
    return Either.right(true);
}

@Override
@Transactional
public Either<PeriodoDTO, Boolean> editarPeriodo(Periodo periodo) {
    var periodoActual = administradorRepository.findPeriodoActual();

    if (periodoActual.isEmpty()) {
        throw ErrorCodeEnum.GE_NOT_FOUND.toBusinessException();
    }

    var p = periodoActual.get();
    var ahora = LocalDateTime.now(BsConstants.DEFAULT_ZONE_ID);

    // Regla GE_RNS005: no se puede editar si el periodo ya inició
    if (ahora.isAfter(p.getFechaInicio())) {
        var afectados = administradorRepository.countEtsAfectadosByFecha(
                p.getFechaInicio(), p.getFechaFin());
        return Either.left(PeriodoDTO.fromEntity(Periodo.builder()
                .idPeriodo(p.getIdPeriodo())
                .nombre(p.getNombre())
                .fechaInicio(p.getFechaInicio())
                .fechaFin(p.getFechaFin())
                .periodoYaComenzo(true)
                .examenesAfectados(afectados)
                .build()));
    }

    // Regla GE_RNS006
    var afectados = administradorRepository.countEtsAfectadosByFecha(
            periodo.getFechaInicio(), periodo.getFechaFin());
    if (afectados > 0) {
        return Either.left(PeriodoDTO.fromEntity(Periodo.builder()
                .idPeriodo(p.getIdPeriodo())
                .nombre(p.getNombre())
                .fechaInicio(p.getFechaInicio())
                .fechaFin(p.getFechaFin())
                .periodoYaComenzo(false)
                .examenesAfectados(afectados)
                .build()));
    }

    administradorRepository.updatePeriodo(periodo);
    return Either.right(true);
}

@Override
@Transactional
public Either<PeriodoDTO, Boolean> eliminarPeriodo(Integer idPeriodo) {
    var ahora = LocalDateTime.now(BsConstants.DEFAULT_ZONE_ID);
    var periodoActual = administradorRepository.findPeriodoActual();

    if (periodoActual.isEmpty()) {
        throw ErrorCodeEnum.GE_NOT_FOUND.toBusinessException();
    }

    var p = periodoActual.get();

    // Regla GE_RNS007
    if (administradorRepository.existsEtsEnPeriodo(idPeriodo)) {
        var afectados = administradorRepository.countEtsAfectadosByFecha(
                p.getFechaInicio(), p.getFechaFin());
        return Either.left(PeriodoDTO.fromEntity(Periodo.builder()
                .idPeriodo(p.getIdPeriodo())
                .nombre(p.getNombre())
                .fechaInicio(p.getFechaInicio())
                .fechaFin(p.getFechaFin())
                .periodoYaComenzo(ahora.isAfter(p.getFechaInicio()))
                .examenesAfectados(afectados)
                .build()));
    }

    administradorRepository.deletePeriodo(idPeriodo);
    return Either.right(true);
}
}
