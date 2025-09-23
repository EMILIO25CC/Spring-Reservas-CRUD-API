package com.desoftcc.dto.salaDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data // Esto integra los: GET, SET, AllConst y NoConst.
@Builder //Esto es para crear una instancia en momento de ejecución.
public class SalaRequestDTO {

    @NotBlank(message = "El nombre de la sala es obligatorio.")
    private String nombre;

    @NotBlank(message = "La capacidad es obligatoria.")
    @Size(min = 20, max = 50)
    private Integer capacidad;

    @NotBlank(message = "La ubicación es obligatoria.")
    private String ubicacion;

    private String recursos;

    private Boolean disponible; // (null para su creación, es decir permanece en estado neutro),  true, false


}/// FIN
