package com.gestion.ets.api.core.business.output;

import com.gestion.ets.api.core.entity.Usuario;

public interface UsuarioRepository {
    /**
     * Guarda al usuario
     * @param entity entidad
     */
    void Save(Usuario entity);

    /**
     * Verifica si el usuario existe mediante su correo electronico
     * @param email correo electronico
     * @return true si existe false si no
     */
    boolean existUsuarioByCorreo(String email);
}
