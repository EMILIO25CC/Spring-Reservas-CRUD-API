package com.desoftcc.repository;

import com.desoftcc.entity.Reserva;
import com.desoftcc.entity.Sala;
import com.desoftcc.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    // En Spring Data JPA los nombres de los métodos deben
    // escribirse estrictamente siguiendo las reglas de convención.
    // El nombre debe coincidir con los atributos exactos de tu entidad.

    /// Este metodo verifica si ya existe una reserva en la misma sala, en la misma fecha y con cruce de horarios.
    ///
    /// Traducción natural:
    ///
    /// “¿Existe ya una reserva en esta sala, ese día,
    ///  donde la hora de inicio y fin se crucen con las que me pasas?”
    boolean existsBySalaAndFechaReservaAndHoraInicioLessThanAndHoraFinGreaterThan(
            Sala sala,
            LocalDate fechaReserva,
            LocalTime horaInicio,
            LocalTime horaFin);

    /// Devuelve todas las reservas de un usuario específico.
    /// Ejemplo: mostrar al usuario su historial de reservas.
    List<Reserva> findByUsuario(Usuario usuario);

    /// Devuelve todas las reservas hechas para una sala en particular.
    /// Ejemplo: mostrar todas las reservas de la Sala de Conferencias A.
    List<Reserva> findBySala(Sala sala);


    /// Devuelve todas las reservas de un día específico.
    /// Ejemplo: listar todas las reservas del 08/09/2025.
    List<Reserva> findByFechaReserva(LocalDate fecha);




}/// FIN
