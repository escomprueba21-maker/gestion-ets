package com.gestion.ets.api.core.business.implementation;

import com.gestion.ets.api.core.business.input.JWTService;
import io.smallrye.jwt.algorithm.SignatureAlgorithm;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

@ApplicationScoped
public class JWTBs implements JWTService {

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String issuer;

    @ConfigProperty(name = "JWT_SECRET")
    String secret;

    @ConfigProperty(name = "jwt.access.duration")
    long accessDuration;

    @ConfigProperty(name = "jwt.refresh.duration")
    long refreshDuration;

    public String generarAccessToken(Integer userId, Integer rolId) {
        return Jwt.issuer(issuer)
                .subject(userId.toString())
                .claim("idRol", rolId)
                .claim("idPersona",userId)
                .expiresIn(Duration.ofSeconds(accessDuration))
                .signWithSecret(secret);
    }

    public String generarRefreshToken(Integer userId) {
        return Jwt.issuer(issuer)
                .subject(userId.toString())
                .claim("type", "refresh")
                .expiresIn(Duration.ofSeconds(refreshDuration))
                .jws()
                .algorithm(SignatureAlgorithm.HS256)
                .sign(getKey());
    }

    private SecretKey getKey() {
        return new SecretKeySpec(
                secret.getBytes(StandardCharsets.UTF_8),
                "HmacSHA256"
        );
    }

}
