package com.gestion.ets.api.util.error;

public interface ErrorCode {
    String getName();

    String getDetail();

    default BusinessException toBusinessException() {
        return new BusinessException(this.getName());
    }
}
