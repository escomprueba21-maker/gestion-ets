package com.escom.external.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Schema(name = "CambiarNombre", description = "DTO para actualizar el nombre del usuario")
public class CambiarNombreDTO {

    @JsonProperty
    @NotBlank(message = "El nombre no puede estar vacío")
    @Schema(description = "Nombre(s) del usuario")
    private String nombre;

    @JsonProperty
    @NotBlank(message = "El primer apellido no puede estar vacío")
    @Schema(description = "Primer apellido del usuario")
    private String primerApellido;

    @JsonProperty
    @NotBlank(message = "El segundo apellido no puede estar vacío")
    @Schema(description = "Segundo apellido del usuario")
    private String segundoApellido;
}
