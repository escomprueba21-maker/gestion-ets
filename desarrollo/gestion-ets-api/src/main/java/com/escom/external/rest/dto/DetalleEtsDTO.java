package com.escom.external.rest.dto;

import com.escom.core.entity.Materia;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Builder
@Schema(name = "DetalleEts", description = "DTO para describir los ETS ligados a una materia")
public class DetalleEtsDTO {

    @JsonProperty
    @Schema(description = "Id de la materia", readOnly = true)
    private Integer id;

    @JsonProperty
    @Schema(description = "Nombre de la materia", readOnly = true)
    private String materia;

    @JsonProperty
    @Schema(description = "Plan de estudios", readOnly = true)
    private String plan;

    @JsonProperty
    @Schema(description = "Fecha del ETS", readOnly = true)
    private String fecha;

    @JsonProperty
    @Schema(description = "Hora del ETS", readOnly = true)
    private String hora;

    @JsonProperty
    @Schema(description = "Turno del ETS", readOnly = true)
    private String turno;

    @JsonProperty
    @Schema(description = "Salón asignado", readOnly = true)
    private String salon;

    @JsonProperty
    @Schema(description = "Nombre del evaluador", readOnly = true)
    private String evaluador;

    @JsonProperty
    @Schema(description = "Carrera de la materia", readOnly = true)
    private String carrera;

    @JsonProperty
    @Schema(description = "Indica si el ETS fue guardado", readOnly = true)
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