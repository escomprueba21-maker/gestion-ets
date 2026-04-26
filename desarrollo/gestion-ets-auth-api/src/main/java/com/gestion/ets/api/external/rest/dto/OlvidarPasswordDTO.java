package com.gestion.ets.api.external.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OlvidarPasswordDTO {
    @JsonProperty
    private String email;
}
