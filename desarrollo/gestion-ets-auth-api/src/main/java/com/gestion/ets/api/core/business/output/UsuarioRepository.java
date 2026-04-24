package com.gestion.ets.api.core.business.output;

import com.gestion.ets.api.core.entity.Auth;
import com.gestion.ets.api.core.entity.Usuario;

import java.util.Optional;

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

    /**
     * Obtiene la informacion del usuario por el token relacionado
     * @param token token del usuario
     * @return {@link Optional<Usuario>}
     */
    Optional<Usuario> findByToken(String token);

    /**
     * crea la relacion usuario-rol
     * @param entity entidad
     */
    void saveRol(Usuario entity);

    /**
     * Confirma la cuenta del usuario
     * y registra la verificación de la persona.
     */
    void confirmarCuentaByIdPersona(Integer idPersona);

    /**
     * Elimina el token
     * @param token token
     */
    void deleteToken(String token);

    Optional<Usuario> findByEmail(String email);

    void deleteTokenByIdPersona(Integer idPersona);

    void updateDatosNoVerificado(Usuario entity);
}
