package com.gestion.ets.api.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RolesEnum {
    ALUMNO(1,"Alumno"),
    ADMINISTRADOR(2,"Administrador");
    private final Integer id;
    private final String nombre;

    public static RolesEnum fromId(Integer id) {
        for (RolesEnum rol : values()) {
            if (rol.getId().equals(id)) {
                return rol;
            }
        }
        throw new IllegalArgumentException("Rol no encontrado para id: " + id);
    }
}
