package com.gestion.ets.api.external.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;


@Getter
@Schema(name = "UpdatePasswordDTO", description = "Datos requeridos para actualizar contraseña")
public class UpdatePasswordDTO {

    @JsonProperty
    @Schema(description = "Token de verificación", writeOnly = true)
    private String token;

    @JsonProperty
    @Schema(description = "Nueva contraseña del usuario", writeOnly = true)
    private String password;
}
