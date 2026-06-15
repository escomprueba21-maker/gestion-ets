package com.gestion.ets.api.external.rest.controller;

import com.gestion.ets.api.core.business.input.UsuarioService;
import com.gestion.ets.api.external.rest.dto.LoginDTO;
import com.gestion.ets.api.external.rest.dto.OlvidarPasswordDTO;
import com.gestion.ets.api.external.rest.dto.PersonaDTO;
import com.gestion.ets.api.external.rest.dto.UpdatePasswordDTO;
import com.gestion.ets.api.util.RefreshDTO;
import com.gestion.ets.api.util.TokenDTO;
import com.gestion.ets.api.util.error.ErrorCode;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthController {

    private final UsuarioService usuarioService;

    @Inject
    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @POST
    @Path("registrarse")
    @Operation(operationId = "registrarse", summary = "Registra un nuevo usuario")
    @APIResponse(responseCode = "200", description = "Usuario registrado correctamente", content = @Content(schema = @Schema(implementation = Boolean.class)))
    public Boolean createPersona(@Valid PersonaDTO personaDTO) {
        return usuarioService.createUsuario(personaDTO.toEntity()).getOrElseThrow(ErrorCode::toBusinessException);
    }

    @POST
    @Operation(operationId = "verificarUsuario", summary = "Verifica un usuario por token")
    @APIResponse(responseCode = "200", description = "Usuario verificado correctamente", content = @Content(schema = @Schema(implementation = Boolean.class)))
    public Boolean verificarUsuarioByToken(@Parameter(description = "token", required = true) @QueryParam("token") String token) {
        return usuarioService.verificarUsuarioByToken(token).getOrElseThrow(ErrorCode::toBusinessException);
    }

    @POST
    @Path("reenviar-token")
    @Operation(operationId = "reenviarToken", summary = "Reenvía el token de confirmación")
    @APIResponse(responseCode = "200", description = "Token reenviado correctamente", content = @Content(schema = @Schema(implementation = Boolean.class)))
    public Boolean reenviarConfirmacion(@Parameter(description = "email", required = true) @QueryParam("email") String email) {
        return usuarioService.reenviarConfirmacion(email).getOrElseThrow(ErrorCode::toBusinessException);
    }

    @POST
    @Path("login")
    @Operation(operationId = "login", summary = "Inicia sesión y retorna un token de acceso")
    @APIResponse(responseCode = "200", description = "Inicio de sesión exitoso", content = @Content(schema = @Schema(implementation = TokenDTO.class)))
    public TokenDTO login(@Valid LoginDTO loginDTO) {
        return usuarioService.login(loginDTO.getEmail(), loginDTO.getPassword(), loginDTO.getToken()).map(TokenDTO::fromEntity).getOrElseThrow(ErrorCode::toBusinessException);
    }

    @POST
    @Path("refresh")
    @Operation(operationId = "refreshToken", summary = "Refresca el token de acceso")
    @APIResponse(responseCode = "200", description = "Token refrescado correctamente", content = @Content(schema = @Schema(implementation = TokenDTO.class)))
    public TokenDTO refresh(@Valid RefreshDTO refreshDTO) {
        return usuarioService.refreshToken(refreshDTO.getRefreshToken())
                .map(TokenDTO::fromEntity)
                .getOrElseThrow(ErrorCode::toBusinessException);
    }

    @POST
    @Path("forgot-password")
    @Operation(operationId = "forgotPassword", summary = "Envía correo para recuperar contraseña")
    @APIResponse(responseCode = "200", description = "Correo de recuperación enviado correctamente", content = @Content(schema = @Schema(implementation = Boolean.class)))
    public Boolean forgotPassword(@Valid OlvidarPasswordDTO olvidarPasswordDTO) {
        return usuarioService.olvidarContrasenia(olvidarPasswordDTO.getEmail()).getOrElseThrow(ErrorCode::toBusinessException);
    }

    @POST
    @Path("update-password")
    @Operation(operationId = "updatePassword", summary = "Actualiza la contraseña del usuario")
    @APIResponse(responseCode = "200", description = "Contraseña actualizada correctamente", content = @Content(schema = @Schema(implementation = Boolean.class)))
    public Boolean updatePassword(@Valid UpdatePasswordDTO updatePasswordDTO) {
        return usuarioService.updatePasswordNueva(updatePasswordDTO.getPassword(), updatePasswordDTO.getToken()).getOrElseThrow(ErrorCode::toBusinessException);
    }

}
