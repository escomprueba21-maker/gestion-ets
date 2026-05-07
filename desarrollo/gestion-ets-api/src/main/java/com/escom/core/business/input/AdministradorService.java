package com.escom.core.business.input;

import com.escom.util.error.ErrorCodeEnum;
import io.vavr.control.Either;

public interface AdministradorService {

    Either<ErrorCodeEnum,Boolean>deleteEtsById(Integer idEts);
}
