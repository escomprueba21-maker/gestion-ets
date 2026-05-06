package com.escom.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ets {
    private Integer idEtsAgenda;
    private Integer idEts;
    private String materia;
    private String fechaHora;
    private Integer diasRestantes;
    private Integer idPersona;
    private LocalDateTime fechaRegistro;
}
