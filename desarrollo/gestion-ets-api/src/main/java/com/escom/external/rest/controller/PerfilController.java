// PerfilController.java
package com.escom.external.rest.controller;

import com.escom.core.entity.Usuario;
import com.escom.external.jpa.dao.PerfilDao;
import com.escom.external.rest.dto.CambiarNombreDTO;
import com.escom.external.rest.dto.CambiarPasswordDTO;
import com.escom.external.rest.dto.PerfilResponseDTO;
import com.escom.util.BsConstants;
import com.escom.util.error.BusinessException;
import com.escom.util.error.ErrorCodeEnum;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.mindrot.jbcrypt.BCrypt;

@Slf4j
@Path("/perfil")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Perfil", description = "Gestión del perfil del usuario autenticado")
public class PerfilController {

    private final PerfilDao perfilDao;
    private final JsonWebToken jwt;

    @Inject
    public PerfilController(PerfilDao perfilDao, JsonWebToken jwt) {
        this.perfilDao = perfilDao;
        this.jwt = jwt;
    }

    private Integer getIdPersona() {
        return Integer.parseInt(jwt.getClaim("idPersona").toString());
    }

    @GET
    @RolesAllowed({BsConstants.ROL_ALUMNO, BsConstants.ROL_ADMINISTRADOR})
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
        Integer idPersona = getIdPersona();

        Usuario usuario = perfilDao.findPerfilByIdPersona(idPersona)
                .orElseThrow(() -> new BusinessException(ErrorCodeEnum.GE_RNN002.getDetail()));

        String rol = usuario.getIdRol() == 1 ? "Alumno" : "Administrador";

        return PerfilResponseDTO.fromEntity(usuario, rol);
    }

    @PUT
    @Path("/nombre")
    @Transactional
    @RolesAllowed({BsConstants.ROL_ALUMNO, BsConstants.ROL_ADMINISTRADOR})
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
        Integer idPersona = getIdPersona();

        perfilDao.findPerfilByIdPersona(idPersona)
                .orElseThrow(() -> new BusinessException(ErrorCodeEnum.GE_RNN002.getDetail()));

        perfilDao.actualizarNombre(
                idPersona,
                dto.getNombre(),
                dto.getPrimerApellido(),
                dto.getSegundoApellido()
        );

        return true;
    }

    @PUT
    @Path("/password")
    @Transactional
    @RolesAllowed({BsConstants.ROL_ALUMNO, BsConstants.ROL_ADMINISTRADOR})
    @Operation(
        operationId = "cambiarPassword",
        summary = "Cambia la contraseña del usuario autenticado",
        description = "Verifica la contraseña actual y guarda la nueva hasheada."
    )
    @RequestBody(
        description = "Contraseña actual y nueva contraseña con confirmación",
        content = @Content(schema = @Schema(implementation = CambiarPasswordDTO.class))
    )
    @APIResponse(responseCode = "200", description = "Contraseña actualizada correctamente")
    @APIResponse(responseCode = "400", description = "Contraseña incorrecta o no coinciden")
    @APIResponse(responseCode = "404", description = "Usuario no encontrado")
    public Boolean cambiarPassword(@Valid CambiarPasswordDTO dto) {
        Integer idPersona = getIdPersona();

        Usuario usuario = perfilDao.findPasswordByIdPersona(idPersona)
                .orElseThrow(() -> new BusinessException(ErrorCodeEnum.GE_RNN002.getDetail()));

        if (!BCrypt.checkpw(dto.getPasswordActual(), usuario.getPassword())) {
            throw new BusinessException(ErrorCodeEnum.GE_RNN005.getDetail());
        }

        if (!dto.getPasswordNueva().equals(dto.getPasswordConfirmacion())) {
            throw new BusinessException(ErrorCodeEnum.GE_RNN006.getDetail());
        }

        String nuevaHasheada = BCrypt.hashpw(dto.getPasswordNueva(), BCrypt.gensalt());
        perfilDao.actualizarPassword(idPersona, nuevaHasheada);

        return true;
    }
}
