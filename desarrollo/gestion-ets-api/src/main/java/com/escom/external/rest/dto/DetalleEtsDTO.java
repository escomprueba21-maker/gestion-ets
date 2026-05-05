package com.escom.external.rest.dto;

import com.escom.core.entity.Materia;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;


@Builder
public class DetalleEtsDTO {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String materia;
    @JsonProperty
    private String plan;
    @JsonProperty
    private String fecha;
    @JsonProperty
    private String hora;
    @JsonProperty
    private String turno;
    @JsonProperty
    private String salon;
    @JsonProperty
    private String evaluador;
    @JsonProperty
    private String carrera;
    @JsonProperty
    private Boolean guardado;

    public static DetalleEtsDTO fromEntity(Materia materia) {
     return DetalleEtsDTO.builder()
             .id(materia.getId())
             .materia(materia.getNombre())
             .plan(materia.getPlan())
             .fecha(materia.getFecha())
             .hora(materia.getHora())
             .salon(materia.getSalon())
             .evaluador(materia.getDocente())
             .carrera(materia.getCarrera())
             .turno(materia.getTurno())
             .guardado(materia.getGuardado())
             .build();
    }
}
