package com.escom.core.entity;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Builder
@Getter
public class Periodo {
    private Integer idPeriodo;
    private String nombre;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Integer idTipoEts;
    private Integer totalExamenes;
    private Integer totalCarreras;
    private Integer totalSalones;
    private String estado; // "vigente", "sin_asignar"
}
