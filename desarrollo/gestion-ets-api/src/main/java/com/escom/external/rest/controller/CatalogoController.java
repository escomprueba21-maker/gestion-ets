package com.escom.external.rest.controller;


import com.escom.core.business.input.CatalogoService;
import com.escom.external.rest.dto.EtsDTO;
import com.escom.util.CatalogoDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import com.escom.util.BsConstants;

@Path("catalogo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CatalogoController {

    private final CatalogoService catalogoService;

    @Inject
    public CatalogoController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    @GET
    @Path("carreras")
    public List<CatalogoDTO> listAllCarreras() {
        return catalogoService.listAllCarreras().stream()
                .map(catalogo -> CatalogoDTO.builder().id(catalogo.getId())
                        .nombre(catalogo.getNombre()).build()).toList();
    }

    @GET
    @Path("ets-by-filtros")
    public List<EtsDTO> listAllEts(@QueryParam("idCarrera")Integer idCarrera,
                                   @QueryParam("idSemestre")Integer idSemestre, @QueryParam("nombre")String nombre) {
        return catalogoService.listEtsByIdCarreraAndIdSemestre(idCarrera,idSemestre,nombre)
                .stream().map(EtsDTO::fromEntity).toList();
    }

    @GET
    @Path("semestres")
    public List<CatalogoDTO> listAllSemestres() {
        return BsConstants.SEMESTRES;
    }
}
