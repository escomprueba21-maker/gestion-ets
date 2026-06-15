package com.gestion.ets.api.core.entity;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dispositivo {

    private Integer idDispositivo;
    private Integer idPersona;
    private Integer idPlataforma;
    private String fcmToken;
    private LocalDateTime fechaRegistro;
}