package com.gestion.ets.api.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion.ets.api.core.entity.Auth;
import lombok.Builder;

@Builder
public class TokenDTO {
    @JsonProperty
    private String token;
    @JsonProperty
    private String refreshToken;

    public static TokenDTO fromEntity (Auth auth) {
        return TokenDTO.builder()
                .token(auth.getToken())
                .refreshToken(auth.getRefreshToken())
                .build();
    }
}
