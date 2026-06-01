package com.escom.external.rest.dto;

import com.escom.core.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Builder
@Schema(name = "Perfil", description = "DTO con la información del perfil del usuario autenticado")
public class PerfilResponseDTO {

    @JsonProperty
    @Schema(description = "Nombre(s) del usuario", readOnly = true)
    private String nombre;

    @JsonProperty
    @Schema(description = "Primer apellido", readOnly = true)
    private String primerApellido;

    @JsonProperty
    @Schema(description = "Segundo apellido", readOnly = true)
    private String segundoApellido;

    @JsonProperty
    @Schema(description = "Correo electrónico", readOnly = true)
    private String email;

    public static PerfilResponseDTO fromEntity(Usuario usuario) {
        return PerfilResponseDTO.builder()
                .nombre(usuario.getNombre())
                .primerApellido(usuario.getPrimerApellido())
                .segundoApellido(usuario.getSegundoApellido())
                .email(usuario.getEmail())
                .build();
    }
}
