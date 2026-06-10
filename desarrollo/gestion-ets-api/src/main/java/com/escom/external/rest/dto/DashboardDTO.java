package com.escom.external.rest.dto;

import com.escom.core.entity.Periodo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import java.util.List;

@Getter
@Builder
@Schema(name = "Dashboard", description = "DTO con la información del dashboard del administrador")
public class DashboardDTO {

    @JsonProperty
    @Schema(description = "Periodo ETS actual", readOnly = true)
    private PeriodoDTO periodo;

    @JsonProperty
    @Schema(description = "Total de exámenes registrados", readOnly = true)
    private Integer totalExamenes;

    @JsonProperty
    @Schema(description = "Total de carreras registradas", readOnly = true)
    private Integer totalCarreras;

    @JsonProperty
    @Schema(description = "Total de salones registrados", readOnly = true)
    private Integer totalSalones;

    @JsonProperty
    @Schema(description = "Exámenes por carrera", readOnly = true)
    private List<CarreraDashboardDTO> examenesPorCarrera;

    public static DashboardDTO fromEntity(Periodo periodo, Integer totalExamenes,
                                          Integer totalCarreras, Integer totalSalones,
                                          List<CarreraDashboardDTO> examenesPorCarrera) {
        return DashboardDTO.builder()
                .periodo(periodo != null ? PeriodoDTO.fromEntity(periodo) : null)
                .totalExamenes(totalExamenes)
                .totalCarreras(totalCarreras)
                .totalSalones(totalSalones)
                .examenesPorCarrera(examenesPorCarrera)
                .build();
    }
}