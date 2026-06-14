package com.escom.external.rest.dto;

import com.escom.core.entity.Examen;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import java.time.LocalDateTime;

@Getter
@Builder
@Schema(name = "Examen", description = "DTO con la información de un examen ETS")
public class ExamenDTO {

    @JsonProperty
    @Schema(description = "Id del examen")
    private Integer idEts;

    @JsonProperty
    @Schema(description = "Id de la materia / unidad de aprendizaje")
    private Integer idMateria;

    @JsonProperty
    @Schema(description = "Nombre de la materia", readOnly = true)
    private String nombreMateria;

    @JsonProperty
    @Schema(description = "Id del docente / profesor evaluador")
    private Integer idDocente;

    @JsonProperty
    @Schema(description = "Nombre del docente", readOnly = true)
    private String nombreDocente;

    @JsonProperty
    @Schema(description = "Id del aula / salón")
    private Integer idAula;

    @JsonProperty
    @Schema(description = "Clave del aula", readOnly = true)
    private String claveAula;

    @JsonProperty
    @Schema(description = "Id del turno")
    private Integer idTurno;

    @JsonProperty
    @Schema(description = "Nombre del turno", readOnly = true)
    private String nombreTurno;

    @JsonProperty
    @Schema(description = "Id del tipo de ETS")
    private Integer idTipoEts;

    @JsonProperty
    @Schema(description = "Fecha y hora de aplicación del examen")
    private LocalDateTime fechaAplicacion;

    public static ExamenDTO fromEntity(Examen examen) {
        return ExamenDTO.builder()
                .idEts(examen.getIdEts())
                .idMateria(examen.getIdMateria())
                .nombreMateria(examen.getNombreMateria())
                .idDocente(examen.getIdDocente())
                .nombreDocente(examen.getNombreDocente())
                .idAula(examen.getIdAula())
                .claveAula(examen.getClaveAula())
                .idTurno(examen.getIdTurno())
                .nombreTurno(examen.getNombreTurno())
                .idTipoEts(examen.getIdTipoEts())
                .fechaAplicacion(examen.getFechaAplicacion())
                .build();
    }
}
