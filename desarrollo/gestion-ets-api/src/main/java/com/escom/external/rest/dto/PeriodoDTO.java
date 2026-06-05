// PeriodoDTO.java
package com.escom.external.rest.dto;

import com.escom.core.entity.Periodo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;

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
    @Schema(description = "Estado del periodo", readOnly = true)
    private String estado;

    public static PeriodoDTO fromEntity(Periodo periodo) {
        return PeriodoDTO.builder()
                .idPeriodo(periodo.getIdPeriodo())
                .nombre(periodo.getNombre())
                .fechaInicio(periodo.getFechaInicio())
                .fechaFin(periodo.getFechaFin())
                .estado(periodo.getEstado())
                .build();
    }
}
