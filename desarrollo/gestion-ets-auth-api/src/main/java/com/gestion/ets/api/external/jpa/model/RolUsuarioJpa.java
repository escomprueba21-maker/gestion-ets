package com.gestion.ets.api.external.jpa.model;

import com.gestion.ets.api.core.entity.Usuario;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "esc03_persona_rol")
public class RolUsuarioJpa {
    @EmbeddedId
    private RolUsuarioIdJpa id;

    public static RolUsuarioJpa fromEntity(Usuario entity) {
        return RolUsuarioJpa.builder()
                .id(RolUsuarioIdJpa.builder()
                        .idPersona(entity.getIdUsuario())
                        .idRol(entity.getIdRol())
                .build())
                .build();
    }

    public Usuario toEntity() {
        return Usuario.builder()
                .idRol(id.getIdRol())
                .idUsuario(id.getIdPersona())
                .build();
    }
}
