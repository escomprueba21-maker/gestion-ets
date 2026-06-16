package com.escom.core.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Aula {
    private Integer id;
    private String clave;
    private String edificio;
}
