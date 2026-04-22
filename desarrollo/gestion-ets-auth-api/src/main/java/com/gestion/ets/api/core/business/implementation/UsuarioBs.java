package com.gestion.ets.api.core.business.implementation;

import com.gestion.ets.api.core.business.input.UsuarioService;
import com.gestion.ets.api.core.business.output.UsuarioRepository;
import com.gestion.ets.api.core.entity.Usuario;
import com.gestion.ets.api.util.BsConstants;
import com.gestion.ets.api.util.error.ErrorCodeEnum;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.vavr.control.Either;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class UsuarioBs implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final Mailer mailer;
    private final Template template;
    @ConfigProperty(name = "app.deeplink.base-url")
    String deeplinkBaseUrl;


    @Inject
    public UsuarioBs(UsuarioRepository usuarioRepository, Mailer mailer, @Location("email/confirmacion") Template template) {
        this.usuarioRepository = usuarioRepository;
        this.mailer = mailer;
        this.template = template;
    }

    @Override
    @Transactional
    public Either<ErrorCodeEnum,Boolean> createUsuario(Usuario entity) {
        if(usuarioRepository.existUsuarioByCorreo(entity.getEmail())) {
            return Either.left(ErrorCodeEnum.GE_RNN001);
        }
        usuarioRepository.Save(Usuario.builder()
                .email(entity.getEmail())
                .nombre(entity.getNombre()).
                primerApellido(entity.getPrimerApellido())
                .segundoApellido(entity.getSegundoApellido())
                .password(BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt()))
                .verificado(Boolean.FALSE)
                .fechaCreacion(LocalDateTime.now(BsConstants.DEFAULT_ZONE_ID))
                .build());
        sendNewConfirmationEmail(entity.getEmail(),String.join(" ",entity.getNombre(),
                entity.getPrimerApellido(), entity.getSegundoApellido()), UUID.randomUUID().toString());
        return Either.right(Boolean.TRUE);
    }


    /**
     * Envia correo de confirmacion del correo para el cliente al registrarse por primera vez
     * @param email correo electronico
     * @param nombre nombre de la persona
     * @param token token que se envia
     */
    public void sendNewConfirmationEmail(String email, String nombre,String token) {
        var link = deeplinkBaseUrl + BsConstants.URL_TOKEN + token;
        var body = template.data("nombre", nombre).data("email", email).data("link",link).render();
        mailer.send(Mail.withHtml(email, "Confirmar Usuario", body));
    }

}
