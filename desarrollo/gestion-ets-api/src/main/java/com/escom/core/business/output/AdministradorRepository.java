package com.escom.core.business.output;

import com.escom.core.entity.Materia;
import com.escom.core.entity.Usuario;

import java.util.List;

public interface AdministradorRepository {

    void deleteEtsById(Integer idEts);
    boolean existsEtsById(Integer idEts);
    List<Usuario> listEtsJoinUsuariosWithFcm(Integer idEts);
    boolean existsPeriodo();
    List<Materia> findSalonesByFiltros(String salon, Integer idEdificio, Integer idSalon);

}
