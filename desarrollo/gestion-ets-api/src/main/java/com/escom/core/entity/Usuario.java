package com.escom.core.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
    private Integer idRol;
    private String fcmToken;
}
