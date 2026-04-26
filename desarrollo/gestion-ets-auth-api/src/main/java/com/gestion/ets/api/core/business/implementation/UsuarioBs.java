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
import io.smallrye.jwt.auth.principal.JWTParser;
import io.smallrye.jwt.auth.principal.ParseException;
import io.vavr.control.Either;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.JsonWebToken;
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
    private final Template forgotPasswordTemplate;
    private final JWTBs jwtBs;
    private final JWTParser jwtParser;

    @ConfigProperty(name = "app.deeplink.base-url")
    String deeplinkBaseUrl;
    @ConfigProperty(name = "app.forgotpassword.base-url")
    String forgotPasswordUrl;

    @Inject
    public UsuarioBs(UsuarioRepository usuarioRepository, Mailer mailer,
                     @Location("email/confirmacion") Template template, JWTBs jwtBs, JWTParser jwtParser,
                     @Location("email/contraseña-olvidada") Template forgotPasswordTemplate) {
        this.usuarioRepository = usuarioRepository;
        this.mailer = mailer;
        this.template = template;
        this.jwtBs = jwtBs;
        this.jwtParser = jwtParser;
        this.forgotPasswordTemplate = forgotPasswordTemplate;
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
        var refreshToken = jwtBs.generarRefreshToken(searchUsuario.get().getIdUsuario());
        return Either.right(Auth.builder().token(token).refreshToken(refreshToken).build());
    }

    @Override
    public Either<ErrorCodeEnum, Auth> refreshToken(String refreshToken) {
        try {
            JsonWebToken jwt = jwtParser.parse(refreshToken);

            String type = jwt.getClaim("type");
            if (!"refresh".equals(type)) {
                return Either.left(ErrorCodeEnum.GE_RNN002);
            }

            var userId = Integer.parseInt(jwt.getSubject());
            var searchUsuario = usuarioRepository.findById(userId);
            if (searchUsuario.isEmpty()) {
                return Either.left(ErrorCodeEnum.GE_RNN002);
            }

            String newAccess = jwtBs.generarAccessToken(searchUsuario.get().getIdUsuario(), searchUsuario.get().getIdRol());
            String newRefresh = jwtBs.generarRefreshToken(searchUsuario.get().getIdUsuario());

            return Either.right(Auth.builder()
                    .token(newAccess)
                    .refreshToken(newRefresh)
                    .build());
        } catch (ParseException e) {
            return Either.left(ErrorCodeEnum.GE_RNN002);
        }
    }

    @Override
    @Transactional
    public Either<ErrorCodeEnum, Boolean> olvidarContrasenia(String email) {
        var searchUsuario = usuarioRepository.findPersonaVerifyByEmail(email);
        var uuid = UUID.randomUUID().toString();
        if (searchUsuario.isEmpty()) {
            return Either.left(ErrorCodeEnum.GE_RNN002);
        }
        usuarioRepository.deleteTokenByIdPersona(searchUsuario.get().getIdUsuario());
        usuarioRepository.createAuthUsuario(Auth.builder()
                .token(uuid)
                .idPersona(searchUsuario.get().getIdUsuario())
                .fechaExpiracion(LocalDateTime.now(BsConstants.DEFAULT_ZONE_ID).plusMinutes(BsConstants.EXPIRACION))
                .build());
        sendNewForgotPasswordEmail(email,searchUsuario.get().getNombre(),uuid);
        return Either.right(Boolean.TRUE);
    }

    @Override
    @Transactional
    public Either<ErrorCodeEnum, Boolean> updatePasswordNueva(String password, String token) {
        var searchUsuario = usuarioRepository.findByToken(token);

        if (searchUsuario.isEmpty()) {
            return Either.left(ErrorCodeEnum.GE_RNN002);
        }

        if (searchUsuario.get().getFechaExpiracion().isBefore(LocalDateTime.now(BsConstants.DEFAULT_ZONE_ID))) {
            return Either.left(ErrorCodeEnum.GE_RNN003);
        }

        var hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        usuarioRepository.actualizarPassword(searchUsuario.get().getIdUsuario(), hashed);
        usuarioRepository.deleteToken(token);
        return Either.right(Boolean.TRUE);
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

    /**
     * Envía correo de contraseña olvidad  al cliente.
     */
    private void sendNewForgotPasswordEmail(String email, String nombre, String token) {
        var link = forgotPasswordUrl + BsConstants.URL_TOKEN + token;
        var body = forgotPasswordTemplate
                .data("nombre", nombre)
                .data("email", email)
                .data("link", link)
                .render();
        mailer.send(Mail.withHtml(email, "Recuperar contraseña", body));
    }
}