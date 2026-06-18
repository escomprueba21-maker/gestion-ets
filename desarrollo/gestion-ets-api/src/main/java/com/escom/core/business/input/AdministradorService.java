package com.escom.core.business.input;

import com.escom.core.entity.Examen;
import com.escom.core.entity.Materia;
import com.escom.core.entity.Periodo;
import com.escom.core.entity.Aula;
import com.escom.core.entity.Carrera;
import com.escom.external.rest.dto.DashboardDTO;
import com.escom.util.error.ErrorCodeEnum;
import io.vavr.control.Either;
import java.util.List;

public interface AdministradorService {
    Either<ErrorCodeEnum, Boolean> deleteEtsById(Integer idEts);
    List<Materia> listSalonesByFiltros(String salon, Integer idEdificio, Integer idSalon);
    Either<ErrorCodeEnum, DashboardDTO> getDashboard();
    Either<ErrorCodeEnum, Boolean> asignarPeriodo(Periodo periodo);
    Either<ErrorCodeEnum, Boolean> editarPeriodo(Periodo periodo);
    Either<ErrorCodeEnum, Boolean> eliminarPeriodo(Integer idPeriodo);
    List<Examen> listExamenesByFiltros(Integer idCarrera, Integer idTurno, Integer idSemestre);
    Either<ErrorCodeEnum, Boolean> crearExamen(Examen examen);
    Either<ErrorCodeEnum, Boolean> editarExamen(Examen examen);
    List<Carrera> listAllCarrerasCompletas();
    Either<ErrorCodeEnum, Boolean> editarCarrera(Carrera carrera);
    Either<ErrorCodeEnum, Boolean> editarAula(Aula aula);
    List<Aula> listAllAulas(String edificio);
    Either<ErrorCodeEnum, Boolean> eliminarCarrera(Integer id);
    Either<ErrorCodeEnum, Boolean> eliminarAula(Integer id);
    Either<ErrorCodeEnum, Boolean> crearCarrera(Carrera carrera);
    Either<ErrorCodeEnum, Boolean> crearAula(Aula aula);
    Either<ErrorCodeEnum, Examen> getById(Integer idExamen);
}
