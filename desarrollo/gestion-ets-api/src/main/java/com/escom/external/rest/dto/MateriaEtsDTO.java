package com.escom.external.rest.dto;

import com.escom.core.entity.Materia;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MateriaEtsDTO {

    @JsonProperty
    private String nombreUsuario;
    @JsonProperty
    private String avatar;
    @JsonProperty
    private String fecha;
    @JsonProperty
    private Integer duracionDias;
    @JsonProperty
    private List<EtsProximosDTO> ets;

    public static MateriaEtsDTO fromEntity(Materia materia) {
        return MateriaEtsDTO.builder()
                .nombreUsuario(materia.getNombreUsuario())
                .fecha(materia.getFecha())
                .duracionDias(materia.getDuracionDias())
                .ets(materia.getEts().stream().map(EtsProximosDTO::fromEntity).toList())
                .build();
    }
}