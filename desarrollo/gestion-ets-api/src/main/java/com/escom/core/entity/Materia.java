package com.escom.core.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Materia {

    private Integer id;
    private String nombre;
    private String docente;
    private String fechaTurno;
    private String salon;

    private String plan;
    private String fecha;
    private String hora;
    private String carrera;
    private Boolean guardado;
    private String turno;
}
