package com.gestion.ets.api.external.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Schema(name = "LoginDTO", description = "Datos requeridos para autenticación")
public class LoginDTO {
    @JsonProperty
    @Email
    @NotNull(message = "CDA_RNS002")
    @Schema(description = "Correo electrónico del usuario", writeOnly = true)
    String email;

    @JsonProperty
    @NotNull(message = "CDA_RNS002")
    @Schema(description = "Contraseña del usuario", writeOnly = true)
    String password;

    @JsonProperty
    @NotNull(message = "CDA_RNS002")
    @Schema(description = "Token de verificación", writeOnly = true)
    String token;
}