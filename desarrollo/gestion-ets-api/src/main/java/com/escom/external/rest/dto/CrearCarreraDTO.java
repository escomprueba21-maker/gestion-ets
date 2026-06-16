package com.escom.external.rest.dto;

import com.escom.core.entity.Carrera;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Schema(name = "CrearCarrera", description = "DTO para crear una carrera")
public class CrearCarreraDTO {

    @JsonProperty
    @NotBlank(message = "GE_RNS001")
    @Schema(description = "Clave de la carrera")
    private String clave;

    @JsonProperty
    @NotBlank(message = "GE_RNS001")
    @Schema(description = "Nombre de la carrera")
    private String nombre;

    public Carrera toEntity() {
        return Carrera.builder()
                .clave(clave)
                .nombre(nombre)
                .build();
    }
}
