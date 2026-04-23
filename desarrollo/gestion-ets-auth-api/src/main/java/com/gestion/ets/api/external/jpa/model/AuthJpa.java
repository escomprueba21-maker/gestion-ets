package com.gestion.ets.api.external.jpa.model;

import com.gestion.ets.api.core.entity.Auth;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "esc04_token_confirmacion")
public class AuthJpa {

    @Id
    @Column(name = "token")
    private String token;
    @Column(name = "fk_id_persona")
    private Integer idPersona;
    @Column(name = "fh_expiracion")
    private LocalDateTime fechaExpiracion;
    @Column(name = "st_usado")
    private Boolean usado;
    @Column(name = "fh_creacion")
    private LocalDateTime fechaCreacion;


    public static AuthJpa fromEntity(Auth entity) {
        return AuthJpa.builder()
                .token(entity.getToken())
                .idPersona(entity.getIdPersona())
                .fechaExpiracion(entity.getFechaExpiracion())
                .usado(entity.getUsado())
                .fechaCreacion(entity.getFechaCreacion())
                .build();
    }

   public Auth toEntity() {
        return Auth.builder()
                .token(token)
                .idPersona(idPersona)
                .fechaExpiracion(fechaExpiracion)
                .usado(usado)
                .fechaCreacion(fechaCreacion)
                .build();
    }
}
