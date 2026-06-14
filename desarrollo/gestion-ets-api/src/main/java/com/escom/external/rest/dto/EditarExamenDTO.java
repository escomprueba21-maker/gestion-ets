package com.escom.external.rest.dto;

import com.escom.core.entity.Examen;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import java.time.LocalDateTime;

@Getter
@Schema(name = "EditarExamen", description = "DTO para editar un examen ETS existente")
public class EditarExamenDTO {

    @JsonProperty
    @NotNull(message = "GE_RNS001")
    @Schema(description = "Id del examen a editar")
    private Integer idEts;

    @JsonProperty
    @NotNull(message = "GE_RNS001")
    @Schema(description = "Id de la materia / unidad de aprendizaje")
    private Integer idMateria;

    @JsonProperty
    @NotNull(message = "GE_RNS001")
    @Schema(description = "Id del docente / profesor evaluador")
    private Integer idDocente;

    @JsonProperty
    @NotNull(message = "GE_RNS001")
    @Schema(description = "Id del aula / salón")
    private Integer idAula;

    @JsonProperty
    @NotNull(message = "GE_RNS001")
    @Schema(description = "Id del turno")
    private Integer idTurno;

    @JsonProperty
    @NotNull(message = "GE_RNS001")
    @Schema(description = "Id del tipo de ETS")
    private Integer idTipoEts;

    @JsonProperty
    @NotNull(message = "GE_RNS001")
    @Schema(description = "Fecha y hora de aplicación del examen")
    private LocalDateTime fechaAplicacion;

    public Examen toEntity() {
        return Examen.builder()
                .idEts(idEts)
                .idMateria(idMateria)
                .idDocente(idDocente)
                .idAula(idAula)
                .idTurno(idTurno)
                .idTipoEts(idTipoEts)
                .fechaAplicacion(fechaAplicacion)
                .build();
    }
}
