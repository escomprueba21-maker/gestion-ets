package com.escom.external.rest.controller;

import com.escom.core.business.input.AdministradorService;
import com.escom.external.rest.dto.*;
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
    @Operation(operationId = "getDashboard", summary = "Obtiene el dashboard del administrador")
    @APIResponse(responseCode = "200", description = "Dashboard obtenido correctamente",
            content = @Content(schema = @Schema(implementation = DashboardDTO.class)))
    public DashboardDTO getDashboard() {
        return administradorService.getDashboard()
                .getOrElseThrow(ErrorCode::toBusinessException);
    }

    @POST
    @Path("periodo")
    @Operation(operationId = "asignarPeriodo", summary = "Asigna un nuevo periodo ETS")
    @APIResponse(responseCode = "200", description = "Periodo asignado correctamente")
    public Boolean asignarPeriodo(@Valid AsignarPeriodoDTO dto) {
        return administradorService.asignarPeriodo(dto.toEntity())
                .getOrElseThrow(ErrorCode::toBusinessException);
    }

    @PUT
    @Path("periodo")
    public Boolean editarPeriodo(@Valid EditarPeriodoDTO dto) {
        return administradorService.editarPeriodo(dto.toEntity())
        .getOrElseThrow(ErrorCode::toBusinessException);
}

    @DELETE
    @Path("periodo/{idPeriodo}")
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
    return List.of();
}

@GET
@Path("examenes")
@Operation(operationId = "listExamenes", summary = "Lista exámenes con filtros opcionales")
@APIResponse(responseCode = "200", description = "Listado de exámenes")
public List<ExamenDTO> listExamenes(@QueryParam("idCarrera") Integer idCarrera,
                                     @QueryParam("idTurno") Integer idTurno,
                                     @QueryParam("idSemestre") Integer idSemestre) {
    return administradorService.listExamenesByFiltros(idCarrera, idTurno, idSemestre)
            .stream().map(ExamenDTO::fromEntity).toList();
}

@POST
@Path("examenes")
@Operation(operationId = "crearExamen", summary = "Crea un nuevo examen")
@APIResponse(responseCode = "200", description = "Examen creado correctamente")
public Boolean crearExamen(@Valid CrearExamenDTO dto) {
    return administradorService.crearExamen(dto.toEntity())
            .getOrElseThrow(ErrorCode::toBusinessException);
}

@PUT
@Path("examenes")
@Operation(operationId = "editarExamen", summary = "Edita un examen existente")
@APIResponse(responseCode = "200", description = "Examen editado correctamente")
@APIResponse(responseCode = "404", description = "Examen no encontrado")
public Boolean editarExamen(@Valid EditarExamenDTO dto) {
    return administradorService.editarExamen(dto.toEntity())
            .getOrElseThrow(ErrorCode::toBusinessException);
}
}
