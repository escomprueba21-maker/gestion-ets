package com.gestion.ets.api.core.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class Auth {
    private String token;
    private Integer idPersona;
    private LocalDateTime fechaExpiracion;

}
