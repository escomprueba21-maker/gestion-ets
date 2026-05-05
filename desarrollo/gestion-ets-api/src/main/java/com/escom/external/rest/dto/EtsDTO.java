package com.escom.external.rest.dto;

import com.escom.core.entity.Materia;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EtsDTO {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String  materia;
    @JsonProperty
    private String  maestro;
    @JsonProperty
    private String  fecha;
    @JsonProperty
    private String  salon;

    public static EtsDTO fromEntity(Materia materia) {
        return EtsDTO.builder()
                .id(materia.getId())
                .materia(materia.getNombre())
                .maestro(materia.getDocente())
                .fecha(materia.getFechaTurno())
                .salon(materia.getSalon())
                .build();
    }
}
