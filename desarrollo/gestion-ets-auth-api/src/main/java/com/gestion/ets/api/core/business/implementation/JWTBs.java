package com.gestion.ets.api.core.business.implementation;

import com.gestion.ets.api.core.business.input.JWTService;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.time.Duration;

@ApplicationScoped
public class JWTBs implements JWTService {
    @ConfigProperty(name = "jwt.duration")
    long durationSeconds;

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String issuer;

    @ConfigProperty(name = "JWT_SECRET")
    String secret;

    public String generarAccessToken(Integer userId, Integer rolId) {

        return Jwt.issuer(issuer)
                .subject(userId.toString())
                .claim("idRol", rolId)
                .claim("idPersona",userId)
                .expiresIn(Duration.ofSeconds(durationSeconds))
                .signWithSecret(secret);
    }

}
