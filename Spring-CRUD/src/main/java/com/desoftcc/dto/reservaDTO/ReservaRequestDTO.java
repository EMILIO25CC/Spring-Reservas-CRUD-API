package com.desoftcc.dto.reservaDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ReservaRequestDTO {

    @NotBlank(message = "La fecha es obligatoria.")
    private LocalDate fechaReserva;

    @NotBlank(message = "La hora de Inicío es obligatoria.")
    private LocalTime horaInicio;

    @NotBlank(message = "La hora de Fin es obligatoria.")
    private LocalTime horaFin;

    @NotBlank(message = "En el motivo describe la reserva.")
    private String motivo;

    private Long usuarioId;
    private Long salaId;


}/// FIN

