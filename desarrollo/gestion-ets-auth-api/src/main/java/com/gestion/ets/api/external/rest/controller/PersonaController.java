package com.gestion.ets.api.external.rest.controller;

import com.gestion.ets.api.core.business.input.UsuarioService;
import com.gestion.ets.api.external.rest.dto.PersonaDTO;
import com.gestion.ets.api.util.error.ErrorCode;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

@Path("registro")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonaController {

    private final UsuarioService usuarioService;

    @Inject
    public PersonaController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @POST
    @Path("persona")
    public Boolean createPersona(@Valid PersonaDTO personaDTO) {
        return usuarioService.createUsuario(personaDTO.toEntity()).getOrElseThrow(ErrorCode::toBusinessException);
    }

    @POST
    public Boolean verificarUsuarioByToken(@Parameter(description = "token", required = true) @QueryParam("token")String token) {
        return usuarioService.verificarUsuarioByToken(token).getOrElseThrow(ErrorCode::toBusinessException);
    }

}
