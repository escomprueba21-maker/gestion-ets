package com.escom.external.rest.controller;

import com.escom.core.business.input.AdministradorService;
import com.escom.external.rest.dto.AsignarPeriodoDTO;
import com.escom.external.rest.dto.DashboardDTO;
import com.escom.external.rest.dto.EditarPeriodoDTO;
import com.escom.external.rest.dto.SalonEtsDTO;
import com.escom.util.BsConstants;
import com.escom.util.error.ErrorCode;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("gestion-ets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed(BsConstants.ROL_ADMINISTRADOR)
@Tag(name = "Administrador", description = "Gestión de ETS para administradores")
public class AdministradorController {

    private final AdministradorService administradorService;

    @Inject
    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GET
    @Path("dashboard")
    @Operation(
        operationId = "getDashboard",
        summary = "Obtiene el dashboard del administrador",
        description = "Devuelve el periodo ETS actual, conteos de exámenes, carreras y salones, y exámenes por carrera."
    )
    @APIResponse(
        responseCode = "200",
        description = "Dashboard obtenido correctamente",
        content = @Content(schema = @Schema(implementation = DashboardDTO.class))
    )
    public DashboardDTO getDashboard() {
        return administradorService.getDashboard()
                .getOrElseThrow(ErrorCode::toBusinessException);
    }

    @POST
    @Path("periodo")
    @Operation(
        operationId = "asignarPeriodo",
        summary = "Asigna un nuevo periodo ETS",
        description = "Crea un nuevo periodo ETS con nombre, fecha de inicio y fecha de fin."
    )
    @RequestBody(
        description = "Datos del periodo a asignar",
        content = @Content(schema = @Schema(implementation = AsignarPeriodoDTO.class))
    )
    @APIResponse(responseCode = "200", description = "Periodo asignado correctamente")
    @APIResponse(responseCode = "400", description = "Datos inválidos")
    public Boolean asignarPeriodo(@Valid AsignarPeriodoDTO dto) {
        return administradorService.asignarPeriodo(dto.toEntity())
                .getOrElseThrow(ErrorCode::toBusinessException);
    }

    @PUT
    @Path("periodo")
    @Operation(
        operationId = "editarPeriodo",
        summary = "Edita el periodo ETS actual",
        description = "Edita el periodo ETS. No es posible modificar si ya comenzó o si hay exámenes afectados."
    )
    @RequestBody(
        description = "Datos del periodo a editar",
        content = @Content(schema = @Schema(implementation = EditarPeriodoDTO.class))
    )
    @APIResponse(responseCode = "200", description = "Periodo editado correctamente")
    @APIResponse(responseCode = "400", description = "No es posible modificar el periodo")
    @APIResponse(responseCode = "404", description = "Periodo no encontrado")
    public Boolean editarPeriodo(@Valid EditarPeriodoDTO dto) {
        return administradorService.editarPeriodo(dto.toEntity())
                .getOrElseThrow(ErrorCode::toBusinessException);
    }

    @DELETE
    @Path("periodo/{idPeriodo}")
    @Operation(
        operationId = "eliminarPeriodo",
        summary = "Elimina el periodo ETS",
        description = "Elimina el periodo ETS. No es posible eliminar si hay exámenes registrados."
    )
    @APIResponse(responseCode = "200", description = "Periodo eliminado correctamente")
    @APIResponse(responseCode = "400", description = "No es posible eliminar el periodo")
    public Boolean eliminarPeriodo(@PathParam("idPeriodo") Integer idPeriodo) {
        return administradorService.eliminarPeriodo(idPeriodo)
                .getOrElseThrow(ErrorCode::toBusinessException);
    }

    @DELETE
    @Path("{idEts}")
    @Operation(operationId = "deleteEtsById", summary = "Elimina un ETS por id")
    @APIResponse(responseCode = "200", description = "ETS eliminado correctamente")
    public boolean deleteEtsById(@PathParam("idEts") Integer idEts) {
        return administradorService.deleteEtsById(idEts)
                .getOrElseThrow(ErrorCode::toBusinessException);
    }

    @GET
    @Path("by-filtros")
    public List<SalonEtsDTO> listEdificiosByFiltros(@QueryParam("salon") String salon,
                                                     @QueryParam("idEdificio") Integer idEdificio,
                                                     @QueryParam("idSalon") Integer idSalon) {
        return null;
    }
}
