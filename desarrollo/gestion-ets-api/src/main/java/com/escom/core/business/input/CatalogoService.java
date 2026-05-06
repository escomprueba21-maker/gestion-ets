package com.escom.core.business.input;

import com.escom.core.entity.Carrera;
import com.escom.core.entity.Materia;
import com.escom.core.entity.Usuario;

import java.util.List;

public interface CatalogoService {

    List<Carrera>listAllCarreras();
    List<Materia>listEtsByIdCarreraAndIdSemestre(Integer idCarrera, Integer idSemestre,String materia);
    List<Materia>listMateriasByIdCarreraAndIdSemestre(Integer idCarrera, Integer idSemestre);
    List<Usuario>listAllDocentes();
}
