package com.gestion.ets.api.util.error;

public class BusinessException extends RuntimeException {
    public BusinessException(String errorCode) {
        super(errorCode);
    }
}
