package com.escom.core.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
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

    private String nombreUsuario;
    private Integer duracionDias;
    private String jsEts;
    private List<Ets> ets;
}
