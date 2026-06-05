package com.escom.core.business.implementation;


import com.escom.core.business.input.AdministradorService;
import com.escom.core.business.output.AdministradorRepository;
import com.escom.core.business.output.UsuarioRepository;
import com.escom.core.entity.Materia;
import com.escom.util.BsConstants;
import com.escom.util.error.ErrorCodeEnum;
import com.escom.core.entity.Periodo;
import com.escom.external.rest.dto.DashboardDTO;
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

    // Agregar estos métodos en AdministradorBs

@Override
public Either<ErrorCodeEnum, DashboardDTO> getDashboard() {
    var periodo = administradorRepository.findPeriodoActual();
    var totalExamenes = administradorRepository.countExamenes();
    var totalCarreras = administradorRepository.countCarreras();
    var totalSalones = administradorRepository.countSalones();
    var examenesPorCarrera = administradorRepository.countExamenesPorCarrera();

    Periodo periodoEntity = null;
    if (periodo.isPresent()) {
        var p = periodo.get();
        var ahora = LocalDateTime.now(BsConstants.DEFAULT_ZONE_ID);
        String estado = (ahora.isAfter(p.getFechaInicio()) && ahora.isBefore(p.getFechaFin()))
                ? "vigente" : "sin_asignar";
        periodoEntity = Periodo.builder()
                .idPeriodo(p.getIdPeriodo())
                .nombre(p.getNombre())
                .fechaInicio(p.getFechaInicio())
                .fechaFin(p.getFechaFin())
                .estado(estado)
                .build();
    }

    return Either.right(DashboardDTO.fromEntity(
            periodoEntity, totalExamenes, totalCarreras, totalSalones, examenesPorCarrera));
}

@Override
@Transactional
public Either<ErrorCodeEnum, Boolean> asignarPeriodo(Periodo periodo) {
    administradorRepository.savePeriodo(periodo);
    return Either.right(true);
}

@Override
@Transactional
public Either<ErrorCodeEnum, Boolean> editarPeriodo(Periodo periodo) {
    var periodoActual = administradorRepository.findPeriodoActual();
    if (periodoActual.isEmpty()) {
        return Either.left(ErrorCodeEnum.GE_NOT_FOUND);
    }

    // Verificar si el periodo ya comenzó
    var ahora = LocalDateTime.now(BsConstants.DEFAULT_ZONE_ID);
    if (ahora.isAfter(periodoActual.get().getFechaInicio())) {
        return Either.left(ErrorCodeEnum.GE_RNS002);
    }

    // Verificar exámenes afectados por cambio de fechas
    var afectados = administradorRepository.countEtsAfectadosByFecha(
            periodo.getFechaInicio(), periodo.getFechaFin());
    if (afectados > 0) {
        return Either.left(ErrorCodeEnum.GE_RNS004);
    }

    administradorRepository.updatePeriodo(periodo);
    return Either.right(true);
}

@Override
@Transactional
public Either<ErrorCodeEnum, Boolean> eliminarPeriodo(Integer idPeriodo) {
    // Verificar si hay exámenes registrados en el periodo
    if (administradorRepository.existsEtsEnPeriodo(idPeriodo)) {
        return Either.left(ErrorCodeEnum.GE_RNS003);
    }
    administradorRepository.deletePeriodo(idPeriodo);
    return Either.right(true);
}
}
