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
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

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
    public Boolean createPersona(@Valid PersonaDTO personaDTO) {
        return usuarioService.createUsuario(personaDTO.toEntity()).getOrElseThrow(ErrorCode::toBusinessException);
    }

    @POST
    public Boolean verificarUsuarioByToken(@Parameter(description = "token", required = true) @QueryParam("token")String token) {
        return usuarioService.verificarUsuarioByToken(token).getOrElseThrow(ErrorCode::toBusinessException);
    }

    @POST
    @Path("reenviar-token")
    public Boolean reenviarConfirmacion(@Parameter(description = "email", required = true) @QueryParam("email") String email) {
        return usuarioService.reenviarConfirmacion(email).getOrElseThrow(ErrorCode::toBusinessException);
    }

    @POST
    @Path("login")
    public TokenDTO login(@Valid LoginDTO loginDTO) {
        return usuarioService.login(loginDTO.getEmail(), loginDTO.getPassword()).map(TokenDTO::fromEntity).getOrElseThrow(ErrorCode::toBusinessException);
    }

    @POST
    @Path("refresh")
    public TokenDTO refresh(@Valid RefreshDTO refreshDTO) {
        return usuarioService.refreshToken(refreshDTO.getRefreshToken())
                .map(TokenDTO::fromEntity)
                .getOrElseThrow(ErrorCode::toBusinessException);
    }

    @POST
    @Path("forgot-password")
    public Boolean forgotPassword(@Valid OlvidarPasswordDTO olvidarPasswordDTO){
        return usuarioService.olvidarContrasenia(olvidarPasswordDTO.getEmail()).getOrElseThrow(ErrorCode::toBusinessException);
    }

    @POST
    @Path("update-password")
    public Boolean updatePassword(@Valid UpdatePasswordDTO updatePasswordDTO) {
        return usuarioService.updatePasswordNueva(updatePasswordDTO.getPassword(),updatePasswordDTO.getToken()).getOrElseThrow(ErrorCode::toBusinessException);
    }

}
