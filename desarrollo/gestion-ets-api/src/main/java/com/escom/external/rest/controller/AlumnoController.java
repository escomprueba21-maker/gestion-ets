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
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("gestion-etsAgenda")
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
    @Operation(operationId = "getEtsById", summary = "Obtiene la informacion de los ets que eligio ", description = "Obtiene los ets que eligio")
    @APIResponse(responseCode = "200", description = "Petición exitosa", content = @Content(schema = @Schema(implementation = DetalleEtsDTO.class)))
    public DetalleEtsDTO getEts(@PathParam("idEts") @Parameter(description = "identificador del ets") Integer idEts) {
        return usuarioService.getEtsById(idEts,getIdPersona()).map(DetalleEtsDTO::fromEntity).getOrElseThrow(ErrorCode::toBusinessException);
    }

    @GET
    @Path("inicio")
    @Operation(
            operationId = "getEtsProximos",
            summary = "Obtiene los ETS próximos",
            description = "Retorna los ETS próximos y su fecha para el usuario autenticado"
    )
    @APIResponse(
            responseCode = "200",
            description = "Petición exitosa",
            content = @Content(schema = @Schema(implementation = MateriaEtsDTO.class))
    )
    public MateriaEtsDTO getEtsProximos() {
        return usuarioService.getEtsProximosAndFecha(getIdPersona())
                .map(MateriaEtsDTO::fromEntity)
                .getOrElseThrow(ErrorCode::toBusinessException);
    }

    @DELETE
    @Path("{idEtsAgenda}")
    @Operation(
            operationId = "deleteEtsAgenda",
            summary = "Elimina un ETS de la agenda",
            description = "Elimina el ETS indicado de la agenda del usuario autenticado"
    )
    @APIResponse(
            responseCode = "200",
            description = "Petición exitosa",
            content = @Content(schema = @Schema(implementation = Boolean.class))
    )
    public Boolean deleteEtsAgenda(@PathParam("idEtsAgenda") Integer idEtsAgenda) {
        return usuarioService.deleteEtsAgendaById(idEtsAgenda, getIdPersona())
                .getOrElseThrow(ErrorCode::toBusinessException);
    }

    @POST
    @Path("{idEts}/agenda")
    @Operation(
            operationId = "createEtsAgenda",
            summary = "Agrega un ETS a la agenda",
            description = "Registra el ETS indicado en la agenda del usuario autenticado"
    )
    @APIResponse(
            responseCode = "200",
            description = "Petición exitosa",
            content = @Content(schema = @Schema(implementation = Boolean.class))
    )
    public Boolean createEtsAgenda(@PathParam("idEts") Integer idEts) {
        return usuarioService.createEtsAgenda(idEts, getIdPersona())
                .getOrElseThrow(ErrorCode::toBusinessException);
    }
}