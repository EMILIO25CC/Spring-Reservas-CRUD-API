package com.desoftcc.dto.salaDTO;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class SalaRequestDTO {

    private String nombre;
    private Integer capacidad;
    private String ubicacion;
    private String recursos;
    private Boolean disponible;


}
