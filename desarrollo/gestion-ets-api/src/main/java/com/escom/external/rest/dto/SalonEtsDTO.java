package com.escom.external.rest.dto;

import com.escom.core.entity.Materia;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class SalonEtsDTO {
    @JsonProperty
    private String salon;
    @JsonProperty
    private String edificio;
    @JsonProperty
    private Boolean editar;
    @JsonProperty
    private Boolean eliminar;


    public static SalonEtsDTO fromEntity(Materia materia) {
        return SalonEtsDTO.builder()
                .salon(materia.getSalon())
                .edificio(materia.getEdificio())
                .editar(materia.getEditar())
                .eliminar(materia.getEliminar())
                .build();
    }
}
