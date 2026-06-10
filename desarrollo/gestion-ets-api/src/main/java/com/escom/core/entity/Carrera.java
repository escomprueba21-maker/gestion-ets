package com.escom.core.entity;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Carrera {

    private Integer id;
    private String nombre;
    private Integer totalExamenes;

    //extras
    private List<Carrera> semestre;
    private List<Integer> ids;
    private List<String> semestres;
}
