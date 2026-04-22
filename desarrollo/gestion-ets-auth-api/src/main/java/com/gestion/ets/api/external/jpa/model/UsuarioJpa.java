package com.gestion.ets.api.external.jpa.model;

import com.gestion.ets.api.core.entity.Usuario;
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
@Table(name = "esc02_persona")
public class UsuarioJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idUsuario;
    @Column(name = "tx_nombre")
    private String nombre;
    @Column(name = "tx_apellido_paterno")
    private String primerApellido;
    @Column(name = "tx_apellido_materno")
    private String segundoApellido;
    @Column(name = "tx_correo")
    private String correo;
    @Column(name = "tx_password")
    private String password;
    @Column(name = "st_verificado")
    private Boolean verificado;
    @Column(name = "fh_registro")
    private LocalDateTime  fechaRegistro;

    public static UsuarioJpa fromEntity(Usuario entity) {
        return UsuarioJpa.builder()
                .idUsuario(entity.getIdUsuario())
                .nombre(entity.getNombre())
                .primerApellido(entity.getPrimerApellido())
                .segundoApellido(entity.getSegundoApellido())
                .correo(entity.getEmail())
                .password(entity.getPassword())
                .verificado(entity.getVerificado())
                .fechaRegistro(entity.getFechaCreacion())
                .build();
    }

    public Usuario toEntity() {
        return Usuario.builder()
                .idUsuario(idUsuario)
                .nombre(nombre)
                .primerApellido(primerApellido)
                .segundoApellido(segundoApellido)
                .email(correo)
                .password(password)
                .verificado(verificado)
                .fechaCreacion(fechaRegistro)
                .build();
    }



}
