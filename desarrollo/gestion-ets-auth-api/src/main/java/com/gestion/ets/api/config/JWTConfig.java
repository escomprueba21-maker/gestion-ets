package com.gestion.ets.api.config;

import io.smallrye.jwt.auth.principal.JWTAuthContextInfo;
import io.smallrye.jwt.algorithm.SignatureAlgorithm;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

@ApplicationScoped
public class JWTConfig {

    @ConfigProperty(name = "JWT_SECRET")
    String secret;

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String issuer;

    @Produces
    @Singleton
    @Alternative
    @Priority(1)
    public JWTAuthContextInfo authContextInfo() {
        SecretKey key = new SecretKeySpec(
                secret.getBytes(StandardCharsets.UTF_8),
                "HmacSHA256"
        );

        JWTAuthContextInfo info = new JWTAuthContextInfo();
        info.setSignatureAlgorithm(Collections.singleton(SignatureAlgorithm.HS256));
        info.setSecretVerificationKey(key);
        info.setIssuedBy(issuer);

        return info;
    }
}