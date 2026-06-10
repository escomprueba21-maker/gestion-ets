package com.escom.util.error;

import lombok.Getter;

@Getter
public class PeriodoConflictoException extends RuntimeException {
    private final String errorCode;
    private final String errorMessage;
    private final Integer examenesAfectados;

    public PeriodoConflictoException(ErrorCodeEnum code, Integer examenesAfectados) {
        super(code.getName());
        this.errorCode = code.getName();
        this.errorMessage = code.getDetail();
        this.examenesAfectados = examenesAfectados;
    }
}
