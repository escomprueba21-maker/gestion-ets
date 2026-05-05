package com.escom.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CatalogoDTO {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String nombre;
}
