package com.escom.core.business.output;

public interface AdministradorRepository {

    void deleteEtsById(Integer idEts);
    boolean existsEtsById(Integer idEts);

}
