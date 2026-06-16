package com.escom.external.rest.dto;

import com.escom.core.entity.Aula;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Schema(name = "CrearAula", description = "DTO para crear un salón")
public class CrearAulaDTO {

    @JsonProperty
    @NotBlank(message = "GE_RNS001")
    @Schema(description = "Clave del salón")
    private String clave;

    @JsonProperty
    @NotBlank(message = "GE_RNS001")
    @Schema(description = "Edificio del salón")
    private String edificio;

    public Aula toEntity() {
        return Aula.builder()
                .clave(clave)
                .edificio(edificio)
                .build();
    }
}
