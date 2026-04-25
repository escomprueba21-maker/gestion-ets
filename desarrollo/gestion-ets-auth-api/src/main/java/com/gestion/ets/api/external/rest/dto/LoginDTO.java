package com.gestion.ets.api.external.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class LoginDTO {
    @JsonProperty
    @Email
    @NotNull(message = "CDA_RNS002")
    String email;
    @JsonProperty
    @NotNull(message = "CDA_RNS002")
    String password;
}
