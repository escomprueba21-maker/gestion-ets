package com.escom.core.business.output;

import com.escom.core.entity.Carrera;
import com.escom.core.entity.Materia;
import com.escom.core.entity.Usuario;

import java.util.List;

public interface CatalogoRepository {

    List<Carrera>findAllCarreras();
    List<Materia>findEtsByIdCarreraAndIdSemestre(Integer idCarrera, Integer idSemestre, String materia);
    List<Materia>findMateriasByIdCarreraAndIdSemestre(Integer idCarrera, Integer idSemestre);
    List<Usuario>findAllDocentes();

}
