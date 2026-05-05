package com.escom.util;
import java.time.ZoneId;
import java.util.List;

public class BsConstants {
    public static final ZoneId DEFAULT_ZONE_ID = ZoneId.of("America/Mexico_City");
    public static final String URL_TOKEN = "?token=";
    public static final Integer EXPIRACION = 15;

    public static final List<CatalogoDTO> SEMESTRES = List.of(
            CatalogoDTO.builder().id(1).nombre("Sem 1").build(),
            CatalogoDTO.builder().id(2).nombre("Sem 2").build(),
            CatalogoDTO.builder().id(3).nombre("Sem 3").build(),
            CatalogoDTO.builder().id(4).nombre("Sem 4").build(),
            CatalogoDTO.builder().id(5).nombre("Sem 5").build(),
            CatalogoDTO.builder().id(6).nombre("Sem 6").build(),
            CatalogoDTO.builder().id(7).nombre("Sem 7").build(),
            CatalogoDTO.builder().id(8).nombre("Sem 8").build()
    );

    public static final String ROL_ALUMNO = "ALUMNO";
    public static final String ROL_ADMINISTRADOR = "ADMINISTRADOR";

}
