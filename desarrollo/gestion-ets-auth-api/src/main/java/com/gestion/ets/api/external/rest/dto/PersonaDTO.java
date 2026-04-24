package com.gestion.ets.api.external.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion.ets.api.core.entity.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PersonaDTO {
    @JsonProperty
    @NotNull(message = "CDA_RNS002")
    private String nombre;
    @JsonProperty
    @NotNull(message = "CDA_RNS002")
    private String primerApellido;
    @JsonProperty
    private String segundoApellido;
    @JsonProperty
    @Email
    @NotNull(message = "CDA_RNS002")
    private String correoElectronico;
    @JsonProperty
    @NotNull(message = "CDA_RNS002")
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
