package com.escom.external.rest.dto;

import com.escom.core.entity.Carrera;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Builder
@Schema(name = "Carrera", description = "DTO con la información de una carrera")
public class CarreraDTO {

    @JsonProperty
    @Schema(description = "Id de la carrera", readOnly = true)
    private Integer id;

    @JsonProperty
    @Schema(description = "Clave de la carrera")
    private String clave;

    @JsonProperty
    @Schema(description = "Nombre de la carrera")
    private String nombre;

    public static CarreraDTO fromEntity(Carrera carrera) {
        return CarreraDTO.builder()
                .id(carrera.getId())
                .clave(carrera.getClave())
                .nombre(carrera.getNombre())
                .build();
    }
}
