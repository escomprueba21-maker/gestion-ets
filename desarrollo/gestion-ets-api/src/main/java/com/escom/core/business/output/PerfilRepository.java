package com.escom.core.business.output;

import com.escom.core.entity.Usuario;
import java.util.Optional;

public interface PerfilRepository {
    Optional<Usuario> findPerfilByIdPersona(Integer idPersona);
    Optional<Usuario> findPasswordByIdPersona(Integer idPersona);
    void actualizarNombre(Integer idPersona, String nombre,
                          String primerApellido, String segundoApellido);
    void actualizarPassword(Integer idPersona, String password);
}
