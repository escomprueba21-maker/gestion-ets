package com.escom.external.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Schema(name = "CambiarPassword", description = "DTO para cambiar la contraseña del usuario")
public class CambiarPasswordDTO {

    @JsonProperty
    @NotBlank(message = "La contraseña actual es requerida")
    @Schema(description = "Contraseña actual del usuario")
    private String passwordActual;

    @JsonProperty
    @NotBlank(message = "La nueva contraseña es requerida")
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$",
        message = "Mínimo 8 caracteres, una mayúscula, un número y un caracter especial"
    )
    @Schema(description = "Nueva contraseña — mínimo 8 caracteres, una mayúscula, un número y un caracter especial")
    private String passwordNueva;

    @JsonProperty
    @NotBlank(message = "Debes confirmar la nueva contraseña")
    @Schema(description = "Confirmación de la nueva contraseña")
    private String passwordConfirmacion;
}
