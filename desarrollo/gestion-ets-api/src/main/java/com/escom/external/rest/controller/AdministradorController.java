package com.escom.external.rest.controller;

import com.escom.core.business.input.AdministradorService;
import com.escom.external.rest.dto.*;
import com.escom.util.BsConstants;
import com.escom.util.error.ErrorCode;
import com.escom.util.error.ErrorCodeEnum;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Operation(operationId = "editarPeriodo", summary = "Edita el periodo ETS actual")
    @APIResponse(responseCode = "200", description = "Periodo editado correctamente")
    @APIResponse(responseCode = "400", description = "No es posible modificar el periodo")
    @APIResponse(responseCode = "404", description = "Periodo no encontrado")
    public Boolean editarPeriodo(@Valid EditarPeriodoDTO dto) {
        var resultado = administradorService.editarPeriodo(dto.toEntity());
        if (resultado.isLeft()) {
            var conflicto = resultado.getLeft();
            // Distinguir si ya comenzó o hay exámenes afectados
            var codigo = Boolean.TRUE.equals(conflicto.getPeriodoYaComenzo())
                    ? ErrorCodeEnum.GE_RNS005
                    : ErrorCodeEnum.GE_RNS006;
            throw new WebApplicationException(
                    buildConflictoResponse(codigo, conflicto));
        }
        return resultado.get();
    }

    @DELETE
    @Path("periodo/{idPeriodo}")
    @Operation(operationId = "eliminarPeriodo", summary = "Elimina el periodo ETS")
    @APIResponse(responseCode = "200", description = "Periodo eliminado correctamente")
    @APIResponse(responseCode = "400", description = "No es posible eliminar el periodo")
    public Boolean eliminarPeriodo(@PathParam("idPeriodo") Integer idPeriodo) {
        var resultado = administradorService.eliminarPeriodo(idPeriodo);
        if (resultado.isLeft()) {
            throw new WebApplicationException(
                    buildConflictoResponse(ErrorCodeEnum.GE_RNS007, resultado.getLeft()));
        }
        return resultado.get();
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

    private Response buildConflictoResponse(ErrorCodeEnum code, PeriodoDTO conflicto) {
        Map<String, Object> detail = new HashMap<>();
        detail.put("code", code.getName());
        detail.put("message", code.getDetail());
        detail.put("info", conflicto);

        Map<String, Object> body = new HashMap<>();
        body.put("status", Response.Status.BAD_REQUEST.getStatusCode());
        body.put("message", Response.Status.BAD_REQUEST.name());
        body.put("details", List.of(detail));

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(body)
                .build();
    }
}
