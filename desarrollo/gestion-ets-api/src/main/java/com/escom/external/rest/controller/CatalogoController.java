package com.escom.external.rest.controller;

import com.escom.core.business.input.CatalogoService;
import com.escom.external.rest.dto.EtsDTO;
import com.escom.util.CatalogoDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import com.escom.util.BsConstants;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

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
    @Operation(
            operationId = "listAllCarreras",
            summary = "Obtiene todas las carreras",
            description = "Retorna el listado completo de carreras disponibles"
    )
    @APIResponse(
            responseCode = "200",
            description = "Petición exitosa",
            content = @Content(schema = @Schema(implementation = CatalogoDTO.class))
    )
    public List<CatalogoDTO> listAllCarreras() {
        return catalogoService.listAllCarreras().stream()
                .map(catalogo -> CatalogoDTO.builder().id(catalogo.getId())
                        .nombre(catalogo.getNombre()).build()).toList();
    }

    @GET
    @Path("ets-by-filtros")
    @Operation(
            operationId = "listAllEts",
            summary = "Obtiene ETS por filtros",
            description = "Retorna el listado de ETS filtrado por carrera, semestre y nombre"
    )
    @APIResponse(
            responseCode = "200",
            description = "Petición exitosa",
            content = @Content(schema = @Schema(implementation = EtsDTO.class))
    )
    public List<EtsDTO> listAllEts(@QueryParam("idCarrera") Integer idCarrera,
                                   @QueryParam("idSemestre") Integer idSemestre,
                                   @QueryParam("nombre") String nombre) {
        return catalogoService.listEtsByIdCarreraAndIdSemestre(idCarrera, idSemestre, nombre)
                .stream().map(EtsDTO::fromEntity).toList();
    }

    @GET
    @Path("semestres")
    @Operation(
            operationId = "listAllSemestres",
            summary = "Obtiene todos los semestres",
            description = "Retorna el listado completo de semestres disponibles"
    )
    @APIResponse(
            responseCode = "200",
            description = "Petición exitosa",
            content = @Content(schema = @Schema(implementation = CatalogoDTO.class))
    )
    public List<CatalogoDTO> listAllSemestres() {
        return BsConstants.SEMESTRES;
    }

    @GET
    @Path("docentes")
    @Operation(
            operationId = "listAllDocentes",
            summary = "Obtiene todos los docentes",
            description = "Retorna el listado completo de docentes registrados"
    )
    @APIResponse(
            responseCode = "200",
            description = "Petición exitosa",
            content = @Content(schema = @Schema(implementation = CatalogoDTO.class))
    )
    public List<CatalogoDTO> listAllDocentes() {
        return catalogoService.listAllDocentes().stream().map(catalogo -> CatalogoDTO.builder()
                .id(catalogo.getIdUsuario())
                .nombre(catalogo.getNombre())
                .build()).toList();
    }

    @GET
    @Path("{idCarrera}/{idSemestre}/materia")
    @Operation(
            operationId = "listMateriasByIdCarreraAndIdSemestre",
            summary = "Obtiene materias por carrera y semestre",
            description = "Retorna el listado de materias filtrado por ID de carrera e ID de semestre"
    )
    @APIResponse(
            responseCode = "200",
            description = "Petición exitosa",
            content = @Content(schema = @Schema(implementation = CatalogoDTO.class))
    )
    public List<CatalogoDTO> listMateriasByIdCarreraAndIdSemestre(
            @PathParam("idCarrera") Integer idCarrera,
            @PathParam("idSemestre") Integer idSemestre) {
        return catalogoService.listMateriasByIdCarreraAndIdSemestre(idCarrera, idSemestre).stream()
                .map(catalogo -> CatalogoDTO.builder()
                        .id(catalogo.getId())
                        .nombre(catalogo.getNombre())
                        .build()).toList();
    }
}