package com.gestion.ets.api.external.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Schema(name = "OlvidarPasswordDTO", description = "Datos requeridos para recuperar contraseña")
public class OlvidarPasswordDTO {

    @JsonProperty
    @Schema(description = "Correo electrónico del usuario", writeOnly = true)
    private String email;
}