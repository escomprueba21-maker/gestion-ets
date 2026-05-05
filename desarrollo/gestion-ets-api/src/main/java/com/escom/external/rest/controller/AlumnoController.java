package com.escom.external.rest.controller;

import com.escom.core.business.input.UsuarioService;
import com.escom.external.rest.dto.DetalleEtsDTO;
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
    public AlumnoController(UsuarioService usuarioService, JsonWebToken jwt) {
        this.usuarioService = usuarioService;
        this.jwt = jwt;
    }

    @GET
    @Path("{idEts}")
    public DetalleEtsDTO getEtsByIdAndIdPersona(@PathParam("idEts") Integer idEts) {
        var idPersona = Integer.parseInt(jwt.getClaim("idPersona").toString());
        return usuarioService.getEtsById(idEts,idPersona).map(DetalleEtsDTO::fromEntity).getOrElseThrow(ErrorCode::toBusinessException);
    }
}