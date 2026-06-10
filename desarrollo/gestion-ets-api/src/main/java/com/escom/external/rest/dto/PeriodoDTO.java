package com.escom.external.rest.dto;

import com.escom.core.entity.Periodo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;

@Getter
@Builder
@Schema(name = "Periodo", description = "DTO con la información del periodo ETS")
public class PeriodoDTO {

    @JsonProperty
    @Schema(description = "Id del periodo", readOnly = true)
    private Integer idPeriodo;

    @JsonProperty
    @Schema(description = "Nombre del periodo", readOnly = true)
    private String nombre;

    @JsonProperty
    @Schema(description = "Fecha de inicio del periodo", readOnly = true)
    private LocalDateTime fechaInicio;

    @JsonProperty
    @Schema(description = "Fecha de fin del periodo", readOnly = true)
    private LocalDateTime fechaFin;

    @JsonProperty
    @Schema(description = "Indica si el periodo ya comenzó — congela botones en el formulario", readOnly = true)
    private Boolean periodoYaComenzo;

    @JsonProperty
    @Schema(description = "Cantidad de exámenes afectados por cambio de fechas", readOnly = true)
    private Integer examenesAfectados;

    public static PeriodoDTO fromEntity(Periodo periodo) {
        return PeriodoDTO.builder()
                .idPeriodo(periodo.getIdPeriodo())
                .nombre(periodo.getNombre())
                .fechaInicio(periodo.getFechaInicio())
                .fechaFin(periodo.getFechaFin())
                .periodoYaComenzo(periodo.getPeriodoYaComenzo())
                .examenesAfectados(periodo.getExamenesAfectados())
                .build();
    }
}
