package com.gestion.ets.api.core.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Usuario {

    private Integer idUsuario;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String email;
    private String password;
    private Boolean verificado;
    private LocalDateTime fechaCreacion;
    private Integer idRol;

    //extras
    private boolean tokenUsado;
    private LocalDateTime fechaExpiracion;
}
