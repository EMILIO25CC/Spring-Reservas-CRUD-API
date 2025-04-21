package com.desoftcc.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaReserva;

    private LocalTime horaInicio;
    private LocalTime horaFin;

    private String motivo;

    /// RELACIONAMOS
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)//no puede ser nulo
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "sala_id", nullable = false)// no puede ser nulo
    private Sala sala;



}//Fin de la clase
