package com.escom.external.rest.dto;

import com.escom.core.entity.Periodo;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;

@Getter
@Schema(name = "AsignarPeriodo", description = "DTO para asignar o editar un periodo ETS")
public class AsignarPeriodoDTO {

    @JsonProperty
    @NotBlank(message = "El nombre del periodo es requerido")
    @Schema(description = "Nombre del periodo")
    private String nombre;

    @JsonProperty
    @NotNull(message = "La fecha de inicio es requerida")
    @Schema(description = "Fecha de inicio del periodo")
    private LocalDateTime fechaInicio;

    @JsonProperty
    @NotNull(message = "La fecha de fin es requerida")
    @Schema(description = "Fecha de fin del periodo")
    private LocalDateTime fechaFin;

    @JsonProperty
    @NotNull(message = "El tipo de ETS es requerido")
    @Schema(description = "Id del tipo de ETS")
    private Integer idTipoEts;

    public Periodo toEntity() {
        return Periodo.builder()
                .nombre(nombre)
                .fechaInicio(fechaInicio)
                .fechaFin(fechaFin)
                .idTipoEts(idTipoEts)
                .build();
    }
}
