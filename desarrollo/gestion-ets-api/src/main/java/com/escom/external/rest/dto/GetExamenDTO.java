package com.escom.external.rest.dto;

import com.escom.core.entity.Examen;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;

@Getter
@Builder
@Schema(name = "GetExamen", description = "DTO para obtener un examen ETS")
public class GetExamenDTO {


    @JsonProperty
    @Schema(description = "Id del examen")
    private Integer idEts;

    @JsonProperty
    @Schema(description = "Id de la materia / unidad de aprendizaje")
    private Integer idMateria;

    @JsonProperty
    @Schema(description = "Id del docente / profesor evaluador")
    private Integer idDocente;

    @JsonProperty
    @Schema(description = "Id del aula / salón")
    private Integer idAula;

    @JsonProperty
    @Schema(description = "Id del turno")
    private Integer idTurno;

    @JsonProperty
    @Schema(description = "Id del tipo de ETS")
    private Integer idTipoEts;

    @JsonProperty
    @Schema(description = "Fecha y hora de aplicación del examen")
    private LocalDateTime fechaAplicacion;

    public static GetExamenDTO fromEntity(Examen examen) {
        return GetExamenDTO.builder()
                .idEts(examen.getIdEts())
                .idMateria(examen.getIdMateria())
                .idDocente(examen.getIdDocente())
                .idAula(examen.getIdAula())
                .idTurno(examen.getIdTurno())
                .idTipoEts(examen.getIdTipoEts())
                .fechaAplicacion(examen.getFechaAplicacion())
                .build();
    }
}
