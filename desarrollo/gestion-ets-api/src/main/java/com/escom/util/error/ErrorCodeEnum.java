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

    GE_RNS005("El periodo ya inició, no es posible modificarlo"),
    GE_RNS006("Existen exámenes fuera del nuevo rango de fechas, no es posible modificar el periodo"),
    GE_RNS007("Existen exámenes registrados en el periodo, no es posible eliminarlo"),
    GE_RNS008("Ya existe un periodo activo, no es posible crear uno nuevo"),

    GE_RNS009("Alguno de los catálogos seleccionados no existe"),
    GE_RNS010("No es posible eliminar la carrera, está en uso por materias o exámenes"),
    GE_RNS011("No es posible eliminar el salón, está en uso por exámenes"),
    GE_RNS012("Ya existe una carrera con esa clave"),
    GE_RNS013("Ya existe un salón con esa clave"),
    

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

    public PeriodoConflictoException toPeriodoConflictoException(Integer examenesAfectados) {
        return new PeriodoConflictoException(this, examenesAfectados);
    }
}
