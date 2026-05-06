package com.escom.external.rest.controller;

import com.escom.core.business.input.UsuarioService;
import com.escom.external.rest.dto.DetalleEtsDTO;
import com.escom.external.rest.dto.MateriaEtsDTO;
import com.escom.util.BsConstants;
import com.escom.util.error.ErrorCode;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("gestion-ets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed(BsConstants.ROL_ALUMNO)
public class AlumnoController {

    private final UsuarioService usuarioService;
    private final JsonWebToken jwt;



    @Inject
    public AlumnoController(UsuarioService usuarioService, JsonWebToken jsonWebToken) {
        this.usuarioService = usuarioService;
        this.jwt = jsonWebToken;
    }

    private Integer getIdPersona() {
        return Integer.parseInt(jwt.getClaim("idPersona").toString());
    }

    @GET
    @Path("{idEts}")
    public DetalleEtsDTO getEtsByIdAndIdPersona(@PathParam("idEts") Integer idEts) {
        return usuarioService.getEtsById(idEts,getIdPersona()).map(DetalleEtsDTO::fromEntity).getOrElseThrow(ErrorCode::toBusinessException);
    }

    @GET
    @Path("inicio")
    public MateriaEtsDTO getEtsProximosByIdPersona(){
        return usuarioService.getEtsProximosAndFechaByIdPersona(getIdPersona()).map(MateriaEtsDTO::fromEntity).getOrElseThrow(ErrorCode::toBusinessException);
    }
}