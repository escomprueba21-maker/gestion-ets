package com.escom.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Builder
@Schema(name = "Catalogo", description = "DTO genérico para catálogos")
public class CatalogoDTO {

    @JsonProperty
    @Schema(description = "Identificador único del catálogo")
    private Integer id;

    @JsonProperty
    @Schema(description = "Nombre del elemento del catálogo")
    private String nombre;
}