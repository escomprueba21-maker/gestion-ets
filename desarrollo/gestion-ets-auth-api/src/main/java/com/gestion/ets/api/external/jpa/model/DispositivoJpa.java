package com.gestion.ets.api.external.jpa.model;

import com.gestion.ets.api.core.entity.Dispositivo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "esc09_dispositivo")
public class DispositivoJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dispositivo")
    private Integer idDispositivo;

    @Column(name = "fk_id_persona")
    private Integer idPersona;

    @Column(name = "fk_id_plataforma")
    private Integer idPlataforma;

    @Column(name = "tx_fcm_token")
    private String fcmToken;

    @Column(name = "fh_registro")
    private LocalDateTime fechaRegistro;


    public static DispositivoJpa fromEntity(Dispositivo entity) {
        return DispositivoJpa.builder()
                .idDispositivo(entity.getIdDispositivo())
                .idPersona(entity.getIdPersona())
                .idPlataforma(entity.getIdPlataforma())
                .fcmToken(entity.getFcmToken())
                .fechaRegistro(entity.getFechaRegistro())
                .build();
    }

    public Dispositivo toEntity() {
        return Dispositivo.builder()
                .idDispositivo(idDispositivo)
                .idPersona(idPersona)
                .idPlataforma(idPlataforma)
                .fcmToken(fcmToken)
                .fechaRegistro(fechaRegistro)
                .build();
    }
}