package com.escom.core.business.implementation;

import com.escom.core.business.input.CatalogoService;
import com.escom.core.business.output.CatalogoRepository;
import com.escom.core.entity.Carrera;
import com.escom.core.entity.Materia;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class CatalogoBs implements CatalogoService {

    private final CatalogoRepository catalogoRepository;

    @Inject
    public CatalogoBs(CatalogoRepository catalogoRepository) {
        this.catalogoRepository = catalogoRepository;
    }
    @Override
    public List<Carrera> listAllCarreras() {
        return catalogoRepository.findAllCarreras();
    }

    @Override
    public List<Materia> listEtsByIdCarreraAndIdSemestre(Integer idCarrera, Integer idSemestre, String materia) {
        return catalogoRepository.findEtsByIdCarreraAndIdSemestre(idCarrera, idSemestre, materia);
    }
}
