package com.desoftcc.dto.reservaDTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ReservaRequestDTO {

    private LocalDate fechaReserva;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String motivo;
    /// Traemos las relaciones
    private Long salaId;
    private Long usuarioId;


}
