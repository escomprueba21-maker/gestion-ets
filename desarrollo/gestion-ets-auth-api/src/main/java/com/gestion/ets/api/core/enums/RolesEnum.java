package com.gestion.ets.api.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RolesEnum {
    ALUMNO(1,"Administrador");
    private Integer id;
    private String nombre;
}
