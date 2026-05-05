package com.escom.core.business.input;

import com.escom.core.entity.Carrera;
import com.escom.core.entity.Materia;

import java.util.List;

public interface CatalogoService {

    List<Carrera>listAllCarreras();
    List<Materia>listEtsByIdCarreraAndIdSemestre(Integer idCarrera, Integer idSemestre,String materia);
}
