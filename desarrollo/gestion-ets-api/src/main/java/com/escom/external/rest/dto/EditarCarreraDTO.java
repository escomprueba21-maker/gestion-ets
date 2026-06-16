package com.escom.external.rest.dto;

import com.escom.core.entity.Carrera;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Schema(name = "EditarCarrera", description = "DTO para editar una carrera existente")
public class EditarCarreraDTO {

    @JsonProperty
    @NotNull(message = "GE_RNS001")
    @Schema(description = "Id de la carrera a editar")
    private Integer id;

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
                .id(id)
                .clave(clave)
                .nombre(nombre)
                .build();
    }
}
