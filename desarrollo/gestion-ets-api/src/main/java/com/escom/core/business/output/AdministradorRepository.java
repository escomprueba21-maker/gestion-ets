package com.escom.core.business.output;

import com.escom.core.entity.Carrera;
import com.escom.core.entity.Materia;
import com.escom.core.entity.Periodo;
import com.escom.core.entity.Usuario;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

public interface AdministradorRepository {

    // existentes
    void deleteEtsById(Integer idEts);
    boolean existsEtsById(Integer idEts);
    List<Usuario> listEtsJoinUsuariosWithFcm(Integer idEts);
    boolean existsPeriodo();
    List<Materia> findSalonesByFiltros(String salon, Integer idEdificio, Integer idSalon);

    // nuevos
    Optional<Periodo> findPeriodoActual();
    Integer countExamenes();
    Integer countCarreras();
    Integer countSalones();
    List<Carrera> countExamenesPorCarrera();
    void savePeriodo(Periodo periodo);
    void updatePeriodo(Periodo periodo);
    void deletePeriodo(Integer idPeriodo);
    boolean existsEtsEnPeriodo(Integer idPeriodo);
    Integer countEtsAfectadosByFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
