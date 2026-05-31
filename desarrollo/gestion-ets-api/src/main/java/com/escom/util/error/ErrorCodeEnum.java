package com.escom.util.error;


public enum ErrorCodeEnum implements ErrorCode {
    // GENERAL
    GE_NOT_FOUND("No se encontró el recurso"),
    GE_ERROR("Error inesperado"),

    // SISTEMA (GE-RS-SXXX)
    GE_RNS001("Campos obligatorios"),
    GE_RNS002("Máquina de estados"),
    GE_RNS003("Elementos registrados en el sistema"),
    GE_RNS004("fecha de periodo no valida"),

    // NEGOCIO (GE-RN-NXXX)
    GE_RNN001("Correo registrado con una cuenta existente"),
    GE_RNN002("Usuario no encontrado"),
    GE_RNN003("El token no es valido"),
    GE_RNN004("Token expirado"),

    GE_RNN005("Contraseña incorrecta"),
    GE_RNN006("Las contraseñas no coinciden");
    
    private final String detail;

    ErrorCodeEnum(String detail) {
        this.detail = detail;
    }

    @Override
    public String getName() {
        return this.toString();
    }

    @Override
    public String getDetail() {
        return this.detail;
    }
}
