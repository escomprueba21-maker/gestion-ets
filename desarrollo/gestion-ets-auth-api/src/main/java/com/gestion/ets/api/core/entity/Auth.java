package com.gestion.ets.api.core.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Auth {
    private String token;
    private Integer idPersona;
    private LocalDateTime fechaExpiracion;
    private String refreshToken;

}
