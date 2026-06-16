package com.escom.external.rest.dto;

import com.escom.core.entity.Aula;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Builder
@Schema(name = "Aula", description = "DTO con la información de un salón")
public class AulaDTO {

    @JsonProperty
    @Schema(description = "Id del salón", readOnly = true)
    private Integer id;

    @JsonProperty
    @Schema(description = "Clave del salón")
    private String clave;

    @JsonProperty
    @Schema(description = "Edificio del salón")
    private String edificio;

    public static AulaDTO fromEntity(Aula aula) {
        return AulaDTO.builder()
                .id(aula.getId())
                .clave(aula.getClave())
                .edificio(aula.getEdificio())
                .build();
    }
}
