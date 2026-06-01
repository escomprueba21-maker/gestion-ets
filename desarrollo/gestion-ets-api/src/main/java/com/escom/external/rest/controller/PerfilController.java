package com.escom.external.rest.controller;

import com.escom.core.business.input.PerfilService;
import com.escom.external.rest.dto.CambiarNombreDTO;
import com.escom.external.rest.dto.CambiarPasswordDTO;
import com.escom.external.rest.dto.PerfilResponseDTO;
import com.escom.util.BsConstants;
import com.escom.util.error.ErrorCode;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/perfil")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({BsConstants.ROL_ALUMNO, BsConstants.ROL_ADMINISTRADOR})
@Tag(name = "Perfil", description = "Gestión del perfil del usuario autenticado")
public class PerfilController {

    private final PerfilService perfilService;
    private final JsonWebToken jwt;

    @Inject
    public PerfilController(PerfilService perfilService, JsonWebToken jwt) {
        this.perfilService = perfilService;
        this.jwt = jwt;
    }

    private Integer getIdPersona() {
        return Integer.parseInt(jwt.getClaim("idPersona").toString());
    }

    @GET
    @Operation(
        operationId = "getPerfil",
        summary = "Obtiene el perfil del usuario autenticado",
        description = "Devuelve nombre, apellidos, email y rol. Reutilizable para pre-llenar las vistas de cambiar nombre y contraseña."
    )
    @APIResponse(
        responseCode = "200",
        description = "Perfil obtenido correctamente",
        content = @Content(schema = @Schema(implementation = PerfilResponseDTO.class))
    )
    public PerfilResponseDTO getPerfil() {
        return perfilService.getPerfil(getIdPersona())
            .map(PerfilResponseDTO::fromEntity)
            .getOrElseThrow(ErrorCode::toBusinessException);
        }

    @PUT
    @Path("/nombre")
    @Operation(
        operationId = "cambiarNombre",
        summary = "Actualiza el nombre del usuario autenticado",
        description = "Permite actualizar nombre(s), primer apellido y segundo apellido."
    )
    @RequestBody(
        description = "Datos del nombre a actualizar",
        content = @Content(schema = @Schema(implementation = CambiarNombreDTO.class))
    )
    @APIResponse(responseCode = "200", description = "Nombre actualizado correctamente")
    @APIResponse(responseCode = "400", description = "Datos inválidos")
    @APIResponse(responseCode = "404", description = "Usuario no encontrado")
    public Boolean cambiarNombre(@Valid CambiarNombreDTO dto) {
        return perfilService.actualizarNombre(
                getIdPersona(),
                dto.getNombre(),
                dto.getPrimerApellido(),
                dto.getSegundoApellido()
        ).getOrElseThrow(ErrorCode::toBusinessException);
    }

    @PUT
    @Path("/password")
    @Operation(
        operationId = "cambiarPassword",
        summary = "Cambia la contraseña del usuario autenticado",
        description = "Verifica la contraseña actual y guarda la nueva hasheada."
    )
    @RequestBody(
        description = "Contraseña actual y nueva con confirmación",
        content = @Content(schema = @Schema(implementation = CambiarPasswordDTO.class))
    )
    @APIResponse(responseCode = "200", description = "Contraseña actualizada correctamente")
    @APIResponse(responseCode = "400", description = "Contraseña incorrecta o no coinciden")
    @APIResponse(responseCode = "404", description = "Usuario no encontrado")
    public Boolean cambiarPassword(@Valid CambiarPasswordDTO dto) {
        return perfilService.cambiarPassword(
                getIdPersona(),
                dto.getPasswordActual(),
                dto.getPasswordNueva(),
                dto.getPasswordConfirmacion()
        ).getOrElseThrow(ErrorCode::toBusinessException);
    }
}
