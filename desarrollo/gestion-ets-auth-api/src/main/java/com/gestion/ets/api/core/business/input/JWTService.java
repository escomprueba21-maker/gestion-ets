package com.gestion.ets.api.core.business.input;

public interface JWTService {

    String generarAccessToken(Integer idPersona,Integer idRol);
    String generarRefreshToken(Integer userId);
}
