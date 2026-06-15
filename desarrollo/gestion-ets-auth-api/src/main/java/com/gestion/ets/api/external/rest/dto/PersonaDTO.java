package com.gestion.ets.api.external.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion.ets.api.core.entity.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Schema(name = "PersonaDTO", description = "Datos requeridos para registro de persona")
public class PersonaDTO {

    @JsonProperty
    @NotNull(message = "CDA_RNS002")
    @Schema(description = "Nombre de la persona", writeOnly = true)
    private String nombre;

    @JsonProperty
    @NotNull(message = "CDA_RNS002")
    @Schema(description = "Primer apellido de la persona", writeOnly = true)
    private String primerApellido;

    @JsonProperty
    @Schema(description = "Segundo apellido de la persona")
    private String segundoApellido;

    @JsonProperty
    @Email
    @NotNull(message = "CDA_RNS002")
    @Schema(description = "Correo electrónico de la persona", writeOnly = true)
    private String correoElectronico;

    @JsonProperty
    @NotNull(message = "CDA_RNS002")
    @Schema(description = "Contraseña de la persona", writeOnly = true)
    private String password;

    public Usuario toEntity() {
        return Usuario.builder()
                .nombre(nombre)
                .primerApellido(primerApellido)
                .segundoApellido(segundoApellido)
                .email(correoElectronico)
                .password(password)
                .build();
    }
}