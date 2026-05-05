package com.escom.util;

import io.smallrye.jwt.algorithm.SignatureAlgorithm;
import io.smallrye.jwt.auth.principal.JWTAuthContextInfo;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Set;

@ApplicationScoped
public class JWTConfig {

    @ConfigProperty(name = "JWT_SECRET")
    String secret;

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String issuer;

    @Produces
    @Singleton
    @Alternative
    @Priority(2000)
    public JWTAuthContextInfo authContextInfo() {
        JWTAuthContextInfo info = new JWTAuthContextInfo();
        info.setIssuedBy(issuer);
        info.setSignatureAlgorithm(Set.of(SignatureAlgorithm.HS256));

        SecretKey key = new SecretKeySpec(
                secret.getBytes(StandardCharsets.UTF_8),
                "HmacSHA256"
        );
        info.setSecretVerificationKey(key);

        return info;
    }
}