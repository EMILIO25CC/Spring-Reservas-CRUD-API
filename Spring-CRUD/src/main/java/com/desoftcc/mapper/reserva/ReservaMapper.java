package com.desoftcc.mapper.reserva;

import com.desoftcc.dto.reservaDTO.ReservaRequestDTO;
import com.desoftcc.dto.reservaDTO.ReservaResponseDTO;
import com.desoftcc.entity.Reserva;
import com.desoftcc.entity.Sala;
import com.desoftcc.entity.Usuario;
import org.springframework.stereotype.Component;

/// Nos aseguramos que la clase sea instanciada por Spring como un (bean)
@Component
public class ReservaMapper {

    /// Convertimos una entidad a un DTO de tipo Response
    public ReservaResponseDTO toDTO(Reserva reserva){
        return ReservaResponseDTO.builder()
                .id(reserva.getId())
                .fechaReserva(reserva.getFechaReserva())
                .horaInicio(reserva.getHoraInicio())
                .horaFin(reserva.getHoraFin())
                .motivo(reserva.getMotivo())

                /// Llamamos a las referencias
                .salaId(reserva.getSala().getId())
                .usuarioId(reserva.getUsuario().getId())

                /// Información de Sala.
                .nombreSala(reserva.getSala().getNombre())
                /// Información de Usuario.
                .nombreUsuario(reserva.getUsuario().getNombreCompleto())

                .build();

    }/// fin toDTO

    /// Convertimos un DTO de tipo Request a una entidad de tipo Reserva con la relación entre Usuario y Sala.
    public Reserva toEntity(ReservaRequestDTO requestDTO, Sala sala, Usuario usuario){
        return Reserva.builder()
                .fechaReserva(requestDTO.getFechaReserva())
                .horaInicio(requestDTO.getHoraInicio())
                .horaFin(requestDTO.getHoraFin())
                .motivo(requestDTO.getMotivo())
                /// Referenciamos.
                .sala(sala)
                .usuario(usuario)
                .build();

    }/// fin toEntity


}/// FIN
