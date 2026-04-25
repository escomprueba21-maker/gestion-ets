package com.gestion.ets.api.core.business.implementation;

import com.gestion.ets.api.core.business.input.UsuarioService;
import com.gestion.ets.api.core.business.output.UsuarioRepository;
import com.gestion.ets.api.core.entity.Auth;
import com.gestion.ets.api.core.entity.Usuario;
import com.gestion.ets.api.core.enums.RolesEnum;
import com.gestion.ets.api.util.BsConstants;
import com.gestion.ets.api.util.error.ErrorCodeEnum;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.quarkus.narayana.jta.QuarkusTransaction;
import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.vavr.control.Either;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class UsuarioBs implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final Mailer mailer;
    private final Template template;
    private final JWTBs jwtBs;

    @ConfigProperty(name = "app.deeplink.base-url")
    String deeplinkBaseUrl;

    @Inject
    public UsuarioBs(UsuarioRepository usuarioRepository, Mailer mailer,
                     @Location("email/confirmacion") Template template, JWTBs jwtBs) {
        this.usuarioRepository = usuarioRepository;
        this.mailer = mailer;
        this.template = template;
        this.jwtBs = jwtBs;
    }

    @Override
    public Either<ErrorCodeEnum, Boolean> createUsuario(Usuario entity) {
        var resultado = QuarkusTransaction.requiringNew().call(() -> registrarUsuario(entity));
        if (resultado.isLeft()) {
            return Either.left(resultado.getLeft());
        }
        var token = resultado.get();
        sendNewConfirmationEmail(entity.getEmail(), Stream.of(entity.getNombre(),
                        entity.getPrimerApellido(), entity.getSegundoApellido())
                        .filter(Objects::nonNull).collect(Collectors.joining(" ")), token);
        return Either.right(Boolean.TRUE);
    }

    protected Either<ErrorCodeEnum, String> registrarUsuario(Usuario entity) {
        var usuarioExistente = usuarioRepository.findByEmail(entity.getEmail());
        var token = UUID.randomUUID().toString();
        int idUsuario;

        if (usuarioExistente.isPresent()) {
            var usuarioNoVerificado = usuarioExistente.get();
            if (Boolean.TRUE.equals(usuarioNoVerificado.getVerificado())) {
                return Either.left(ErrorCodeEnum.GE_RNN001);
            }
            usuarioRepository.updateDatosNoVerificado(Usuario.builder()
                    .idUsuario(usuarioNoVerificado.getIdUsuario())
                    .nombre(entity.getNombre())
                    .primerApellido(entity.getPrimerApellido())
                    .segundoApellido(entity.getSegundoApellido())
                    .password(BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt()))
                    .build());
            usuarioRepository.deleteTokenByIdPersona(usuarioNoVerificado.getIdUsuario());
            idUsuario = usuarioNoVerificado.getIdUsuario();
        } else {
            var usuarioRegistrado = usuarioRepository.Save(Usuario.builder()
                    .email(entity.getEmail())
                    .nombre(entity.getNombre())
                    .primerApellido(entity.getPrimerApellido())
                    .segundoApellido(entity.getSegundoApellido())
                    .password(BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt()))
                    .verificado(Boolean.FALSE)
                    .fechaCreacion(LocalDateTime.now(BsConstants.DEFAULT_ZONE_ID))
                    .build());
            idUsuario = usuarioRegistrado.getIdUsuario();
        }
        usuarioRepository.createAuthUsuario(Auth.builder()
                .token(token).idPersona(idUsuario)
                .fechaExpiracion(LocalDateTime.now(BsConstants.DEFAULT_ZONE_ID).plusMinutes(BsConstants.EXPIRACION))
                .build());
        return Either.right(token);
    }

    @Override
    @Transactional
    public Either<ErrorCodeEnum, Boolean> verificarUsuarioByToken(String token) {
        var searchUsuario = usuarioRepository.findByToken(token);
        if (searchUsuario.isEmpty()) {
            return Either.left(ErrorCodeEnum.GE_RNN003);
        }
        var auth = searchUsuario.get();
        if (auth.getFechaExpiracion().isBefore(LocalDateTime.now(BsConstants.DEFAULT_ZONE_ID))) {
            return Either.left(ErrorCodeEnum.GE_RNN004);
        }
        usuarioRepository.confirmarCuentaByIdPersona(auth.getIdUsuario());
        usuarioRepository.saveRol(Usuario.builder()
                .idRol(RolesEnum.ALUMNO.getId())
                .idUsuario(auth.getIdUsuario())
                .build());
        usuarioRepository.deleteToken(token);
        return Either.right(Boolean.TRUE);
    }

    @Override
    public Either<ErrorCodeEnum, Boolean> reenviarConfirmacion(String email) {
        var resultado = QuarkusTransaction.requiringNew().call(() -> regenerarToken(email));
        if (resultado.isLeft()) {
            return Either.left(resultado.getLeft());
        }
        var usuario = usuarioRepository.findByEmail(email).orElseThrow();
        sendNewConfirmationEmail(email,
                Stream.of(usuario.getNombre(), usuario.getPrimerApellido(), usuario.getSegundoApellido())
                        .filter(Objects::nonNull).collect(Collectors.joining(" ")),
                resultado.get());
        return Either.right(Boolean.TRUE);
    }

    @Override
    public Either<ErrorCodeEnum, Auth> login(String email, String password) {
        var searchUsuario = usuarioRepository.findPersonaVerifyByEmail(email);
        if (searchUsuario.isEmpty()) {
            return Either.left(ErrorCodeEnum.GE_RNN002);
        }
        if (!BCrypt.checkpw(password, searchUsuario.get().getPassword())) {
            return Either.left(ErrorCodeEnum.GE_RNN002);
        }
         var token = jwtBs.generarAccessToken(searchUsuario.get().getIdUsuario(),searchUsuario.get().getIdRol());
        return Either.right(Auth.builder().token(token).build());
    }

    protected Either<ErrorCodeEnum, String> regenerarToken(String email) {
        var usuarioExistente = usuarioRepository.findByEmail(email);
        if (usuarioExistente.isEmpty()) {
            return Either.left(ErrorCodeEnum.GE_RNN002);
        }
        var usuarioNoVerificado = usuarioExistente.get();
        if (Boolean.TRUE.equals(usuarioNoVerificado.getVerificado())) {
            return Either.left(ErrorCodeEnum.GE_RNN001);
        }
        usuarioRepository.deleteTokenByIdPersona(usuarioNoVerificado.getIdUsuario());
        var token = UUID.randomUUID().toString();
        usuarioRepository.createAuthUsuario(Auth.builder()
                .token(token)
                .idPersona(usuarioNoVerificado.getIdUsuario())
                .fechaExpiracion(LocalDateTime.now(BsConstants.DEFAULT_ZONE_ID)
                        .plusMinutes(BsConstants.EXPIRACION))
                .build());
        return Either.right(token);
    }


    /**
     * Envía correo de confirmación al cliente al registrarse por primera vez.
     */
    private void sendNewConfirmationEmail(String email, String nombre, String token) {
        var link = deeplinkBaseUrl + BsConstants.URL_TOKEN + token;
        var body = template
                .data("nombre", nombre)
                .data("email", email)
                .data("link", link)
                .render();
        mailer.send(Mail.withHtml(email, "Confirmar Usuario", body));
    }
}