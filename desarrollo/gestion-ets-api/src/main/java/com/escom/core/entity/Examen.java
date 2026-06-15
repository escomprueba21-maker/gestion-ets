package com.escom.core.entity;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Builder
@Getter
public class Examen {
    private Integer idEts;
    private Integer idMateria;
    private Integer idDocente;
    private Integer idAula;
    private Integer idTurno;
    private Integer idTipoEts;
    private LocalDateTime fechaAplicacion;

    // Solo para el listado (display)
    private String nombreMateria;
    private String nombreDocente;
    private String claveAula;
    private String nombreTurno;
}
