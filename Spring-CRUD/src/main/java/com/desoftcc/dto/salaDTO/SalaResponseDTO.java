package com.desoftcc.dto.salaDTO;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class SalaResponseDTO {


    private Long id;

    private String nombre;
    private Integer capacidad;
    private String ubicacion;
    private String recursos;
    private boolean disponible;  // true - false



}
