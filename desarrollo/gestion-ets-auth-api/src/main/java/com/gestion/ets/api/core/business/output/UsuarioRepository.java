package com.gestion.ets.api.core.business.output;

import com.gestion.ets.api.core.entity.Auth;
import com.gestion.ets.api.core.entity.Usuario;

public interface UsuarioRepository {
    /**
     * Guarda al usuario
     * @param entity entidad
     */
    Usuario Save(Usuario entity);

    /**
     * Verifica si el usuario existe mediante su correo electronico
     * @param email correo electronico
     * @return true si existe false si no
     */
    boolean existUsuarioByCorreo(String email);

    /**
     * Crea el token para el usuario
     * @param entity entidad
     */
    void createAuthUsuario(Auth entity);
}
