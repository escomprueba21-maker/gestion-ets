package com.escom.util.paginacion;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Paginacion {
    private Integer numeroPagina;
    private Integer cantidadFilas;
}
