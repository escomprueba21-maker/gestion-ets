package com.gestion.ets.api.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshDTO {
    @JsonProperty
    @NotNull(message = "CDA_RNS002")
    private String refreshToken;
}