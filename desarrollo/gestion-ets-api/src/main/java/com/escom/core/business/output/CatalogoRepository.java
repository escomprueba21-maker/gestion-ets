package com.escom.core.business.output;

import com.escom.core.entity.Carrera;
import com.escom.core.entity.Materia;

import java.util.List;

public interface CatalogoRepository {

    List<Carrera>findAllCarreras();
    List<Materia>findEtsByIdCarreraAndIdSemestre(Integer idCarrera, Integer idSemestre, String materia);

}
