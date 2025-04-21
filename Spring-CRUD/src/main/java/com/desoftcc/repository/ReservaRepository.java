package com.desoftcc.repository;

import com.desoftcc.entity.Reserva;
import com.desoftcc.entity.Sala;
import com.desoftcc.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    /**
     * Verifica si existe una reserva para la misma sala y fecha donde:
     * - La hora de inicio de la reserva existente es antes de la hora final propuesta
     * - Y la hora final de la reserva existente es después de la hora inicial propuesta
     * (Es decir, detecta solapamientos de horarios)
     */
    boolean existsBySalaAndFechaReservaAndHoraInicioLessThanAndHoraFinGreaterThan(
            Sala sala,
            LocalDate fechaReserva,
            LocalTime horaFin,
            LocalTime horaInicio);

    List<Reserva> findByUsuario(Usuario usuario);
    List<Reserva> findBySala(Sala sala);
    List<Reserva> findByFechaReserva(LocalDate fecha);

}///
