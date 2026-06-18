package com.escom.core.business.output;

import com.escom.core.entity.Carrera;
import com.escom.core.entity.Examen;
import com.escom.core.entity.Materia;
import com.escom.core.entity.Periodo;
import com.escom.core.entity.Usuario;
import com.escom.core.entity.Aula;
import com.escom.util.error.ErrorCodeEnum;
import io.vavr.control.Either;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AdministradorRepository {
    void deleteEtsById(Integer idEts);
    boolean existsEtsById(Integer idEts);
    List<Usuario> listEtsJoinUsuariosWithFcm(Integer idEts);
    boolean existsPeriodo();
    List<Materia> findSalonesByFiltros(String salon, Integer idEdificio, Integer idSalon);
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
    Integer countEtsEnPeriodo(Integer idPeriodo);
    List<Examen> findExamenesByFiltros(Integer idCarrera, Integer idTurno, Integer idSemestre);
    void createExamen(Examen examen);
    void updateExamen(Examen examen);
    boolean existsCatalogosExamen(Examen examen);

    List<Carrera> findAllCarrerasCompletas();
    void createCarrera(Carrera carrera);
    void updateCarrera(Carrera carrera);
    boolean existsCarreraById(Integer id);
    boolean existsCarreraByClave(String clave);
    void deleteCarrera(Integer id);
    boolean existsCarreraEnUso(Integer id);

    List<Aula> findAllAulas(String edificio);
    void createAula(Aula aula);
    void updateAula(Aula aula);
    boolean existsAulaById(Integer id);
    boolean existsAulaByClave(String clave);
    void deleteAula(Integer id);
    boolean existsAulaEnUso(Integer id);
    Optional<Examen> findById(Integer idExamen);

}
