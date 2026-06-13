package com.gestion.ets.api.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumDispositivos {
    ANDROID(1,"Android"),
    IOS(2,"IOS");
    private final Integer id;
    private final String nombre;

}
