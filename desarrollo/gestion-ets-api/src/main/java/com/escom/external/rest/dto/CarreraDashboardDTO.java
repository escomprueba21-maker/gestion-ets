package com.escom.external.rest.dto;

import com.escom.core.entity.Carrera;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Builder
@Schema(name = "CarreraDashboard", description = "DTO con la cantidad de exámenes por carrera")
public class CarreraDashboardDTO {

    @JsonProperty
    @Schema(description = "Id de la carrera", readOnly = true)
    private Integer id;

    @JsonProperty
    @Schema(description = "Nombre de la carrera", readOnly = true)
    private String nombre;

    @JsonProperty
    @Schema(description = "Total de exámenes en la carrera", readOnly = true)
    private Integer totalExamenes;

    public static CarreraDashboardDTO fromEntity(Carrera carrera) {
        return CarreraDashboardDTO.builder()
                .id(carrera.getId())
                .nombre(carrera.getNombre())
                .totalExamenes(carrera.getTotalExamenes())
                .build();
    }
}
