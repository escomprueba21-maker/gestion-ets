package com.escom.core.business.input;

import com.escom.core.entity.Materia;
import com.escom.core.entity.Periodo;
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
}
