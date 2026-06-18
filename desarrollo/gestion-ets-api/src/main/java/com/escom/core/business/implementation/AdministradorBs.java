package com.escom.core.business.implementation;


import com.escom.core.business.input.AdministradorService;
import com.escom.core.business.output.AdministradorRepository;
import com.escom.core.business.output.UsuarioRepository;
import com.escom.core.entity.Examen;
import com.escom.core.entity.Materia;
import com.escom.util.BsConstants;
import com.escom.util.error.ErrorCodeEnum;
import com.escom.core.entity.Periodo;
import com.escom.core.entity.Aula;
import com.escom.core.entity.Carrera;
import com.escom.external.rest.dto.CarreraDashboardDTO;
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

    Periodo periodoEntity = null;
    if (periodo.isPresent()) {
        var p = periodo.get();
        var ahora = LocalDateTime.now(BsConstants.DEFAULT_ZONE_ID);
        periodoEntity = Periodo.builder()
                .idPeriodo(p.getIdPeriodo())
                .nombre(p.getNombre())
                .fechaInicio(p.getFechaInicio())
                .fechaFin(p.getFechaFin())
                .periodoYaComenzo(ahora.isAfter(p.getFechaInicio()))
                .examenesAfectados(0)
                .build();
    }

    return Either.right(DashboardDTO.fromEntity(
            periodoEntity,
            totalExamenes,
            totalCarreras,
            totalSalones,
            examenesPorCarrera));
}

@Override
@Transactional
public Either<ErrorCodeEnum, Boolean> asignarPeriodo(Periodo periodo) {
    if (administradorRepository.findPeriodoActual().isPresent()) {
        return Either.left(ErrorCodeEnum.GE_RNS008);
    }
    administradorRepository.savePeriodo(periodo);
    return Either.right(true);
}

@Override
@Transactional
public Either<ErrorCodeEnum, Boolean> editarPeriodo(Periodo periodo) {
    var periodoActual = administradorRepository.findPeriodoActual();

    if (periodoActual.isEmpty()) {
        throw ErrorCodeEnum.GE_NOT_FOUND.toBusinessException();
    }

    var p = periodoActual.get();
    var ahora = LocalDateTime.now(BsConstants.DEFAULT_ZONE_ID);

    // Regla GE_RNS005
    if (ahora.isAfter(p.getFechaInicio())) {
        var afectados = administradorRepository.countEtsAfectadosByFecha(
                p.getFechaInicio(), p.getFechaFin());
        throw ErrorCodeEnum.GE_RNS005.toPeriodoConflictoException(afectados);
    }

    // Regla GE_RNS006
    var afectados = administradorRepository.countEtsAfectadosByFecha(
            periodo.getFechaInicio(), periodo.getFechaFin());
    if (afectados > 0) {
        throw ErrorCodeEnum.GE_RNS006.toPeriodoConflictoException(afectados);
    }

    administradorRepository.updatePeriodo(periodo);
    return Either.right(true);
}

@Override
@Transactional
public Either<ErrorCodeEnum, Boolean> eliminarPeriodo(Integer idPeriodo) {
    var periodoActual = administradorRepository.findPeriodoActual();

    if (periodoActual.isEmpty()) {
        throw ErrorCodeEnum.GE_NOT_FOUND.toBusinessException();
    }

    if (administradorRepository.existsEtsEnPeriodo(idPeriodo)) {
        var afectados = administradorRepository.countEtsEnPeriodo(idPeriodo);
        throw ErrorCodeEnum.GE_RNS007.toPeriodoConflictoException(afectados);
    }

    administradorRepository.deletePeriodo(idPeriodo);
    return Either.right(true);
}

@Override
public List<Examen> listExamenesByFiltros(Integer idCarrera, Integer idTurno, Integer idSemestre) {
    return administradorRepository.findExamenesByFiltros(idCarrera, idTurno, idSemestre);
}

@Override
@Transactional
public Either<ErrorCodeEnum, Boolean> crearExamen(Examen examen) {
    if (!administradorRepository.existsCatalogosExamen(examen)) {
        return Either.left(ErrorCodeEnum.GE_RNS009);
    }
    administradorRepository.createExamen(examen);
    return Either.right(true);
}

@Override
@Transactional
public Either<ErrorCodeEnum, Boolean> editarExamen(Examen examen) {
    if (!administradorRepository.existsEtsById(examen.getIdEts())) {
        return Either.left(ErrorCodeEnum.GE_NOT_FOUND);
    }
    if (!administradorRepository.existsCatalogosExamen(examen)) {
        return Either.left(ErrorCodeEnum.GE_RNS009);
    }
    administradorRepository.updateExamen(examen);
    return Either.right(true);
}

@Override
public List<Carrera> listAllCarrerasCompletas() {
    return administradorRepository.findAllCarrerasCompletas();
}

@Override
@Transactional
public Either<ErrorCodeEnum, Boolean> crearCarrera(Carrera carrera) {
    if (administradorRepository.existsCarreraByClave(carrera.getClave())) {
        return Either.left(ErrorCodeEnum.GE_RNS012);
    }
    administradorRepository.createCarrera(carrera);
    return Either.right(true);
}

@Override
@Transactional
public Either<ErrorCodeEnum, Boolean> editarCarrera(Carrera carrera) {
    if (!administradorRepository.existsCarreraById(carrera.getId())) {
        return Either.left(ErrorCodeEnum.GE_NOT_FOUND);
    }
    administradorRepository.updateCarrera(carrera);
    return Either.right(true);
}

@Override
@Transactional
public Either<ErrorCodeEnum, Boolean> eliminarCarrera(Integer id) {
    if (!administradorRepository.existsCarreraById(id)) {
        return Either.left(ErrorCodeEnum.GE_NOT_FOUND);
    }
    if (administradorRepository.existsCarreraEnUso(id)) {
        return Either.left(ErrorCodeEnum.GE_RNS010);
    }
    administradorRepository.deleteCarrera(id);
    return Either.right(true);
}

@Override
public List<Aula> listAllAulas(String edificio) {
    return administradorRepository.findAllAulas(edificio);
}

@Override
@Transactional
public Either<ErrorCodeEnum, Boolean> crearAula(Aula aula) {
    if (administradorRepository.existsAulaByClave(aula.getClave())) {
        return Either.left(ErrorCodeEnum.GE_RNS013);
    }
    administradorRepository.createAula(aula);
    return Either.right(true);
}

@Override
@Transactional
public Either<ErrorCodeEnum, Boolean> editarAula(Aula aula) {
    if (!administradorRepository.existsAulaById(aula.getId())) {
        return Either.left(ErrorCodeEnum.GE_NOT_FOUND);
    }
    administradorRepository.updateAula(aula);
    return Either.right(true);
}

@Override
@Transactional
public Either<ErrorCodeEnum, Boolean> eliminarAula(Integer id) {
    if (!administradorRepository.existsAulaById(id)) {
        return Either.left(ErrorCodeEnum.GE_NOT_FOUND);
    }
    if (administradorRepository.existsAulaEnUso(id)) {
        return Either.left(ErrorCodeEnum.GE_RNS011);
    }
    administradorRepository.deleteAula(id);
    return Either.right(true);
}
}
