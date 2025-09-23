package com.desoftcc.dto.reservaDTO;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Data
public class ReservaResponseDTO {
/// Las DTO pueden juntar información de varias tablas para mostror
/// un resultado final.
    private Long id;
    private LocalDate fechaReserva;

    private LocalTime horaInicio;
    private LocalTime horaFin;

    private String motivo;

    // traemos + información
    private String nombreSala;
    private String nombreUsuario;


    /// Traemos las relaciones
    private Long salaId;
    private Long usuarioId;

}
