package com.escom.external.rest.controller;

import com.escom.core.business.input.AdministradorService;
import com.escom.external.rest.dto.SalonEtsDTO;
import com.escom.util.BsConstants;
import com.escom.util.error.ErrorCode;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("gestion-ets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed(BsConstants.ROL_ADMINISTRADOR)
public class AdministradorController {

    private final AdministradorService administradorService;

    @Inject
    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @DELETE
    @Path("{idEts}")
    public boolean deleteEtsById(@PathParam("idEts") Integer idEts) {
       return administradorService.deleteEtsById(idEts).getOrElseThrow(ErrorCode::toBusinessException);
    }

    @GET
    @Path("by-filtros")
    public List<SalonEtsDTO> listEdificiosByFiltros(@QueryParam("salon")String salon, @QueryParam("idEdificio")Integer idEdificio,
                                                    @QueryParam("idSalon")Integer idSalon){
       return null;
    }
}
