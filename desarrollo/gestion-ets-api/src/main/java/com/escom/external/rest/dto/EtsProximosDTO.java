package com.escom.external.rest.dto;

import com.escom.core.entity.Ets;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EtsProximosDTO {

    @JsonProperty
    private Integer idEtsAgenda;
    @JsonProperty
    private Integer idEts;
    @JsonProperty
    private String materia;
    @JsonProperty
    private String fechaHora;
    @JsonProperty
    private Integer diasRestantes;

    public static EtsProximosDTO fromEntity(Ets ets) {
        return EtsProximosDTO.builder()
                .idEtsAgenda(ets.getIdEtsAgenda())
                .idEts(ets.getIdEts())
                .materia(ets.getMateria())
                .fechaHora(ets.getFechaHora())
                .diasRestantes(ets.getDiasRestantes())
                .build();
    }
}
