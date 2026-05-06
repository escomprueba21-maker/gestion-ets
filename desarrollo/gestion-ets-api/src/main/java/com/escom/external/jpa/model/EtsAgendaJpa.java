package com.escom.external.jpa.model;

import com.escom.core.entity.Ets;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "esc08_agenda_ets")
public class EtsAgendaJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agenda_ets")
    private Integer idAgendaEts;

    @Column(name = "fk_id_persona")
    private Integer idPersona;

    @Column(name = "fk_id_ets")
    private Integer idEts;

    @Column(name = "fh_registro")
    private LocalDateTime fechaRegistro;

    public static EtsAgendaJpa fromEntity(Ets entity) {
        return EtsAgendaJpa.builder()
                .idAgendaEts(entity.getIdEtsAgenda())
                .idPersona(entity.getIdPersona())
                .idEts(entity.getIdEts())
                .fechaRegistro(entity.getFechaRegistro())
                .build();
    }

    public Ets toEntity() {
        return Ets.builder()
                .idEtsAgenda(idAgendaEts)
                .idPersona(idPersona)
                .idEts(idEts)
                .fechaRegistro(fechaRegistro)
                .build();
    }
}