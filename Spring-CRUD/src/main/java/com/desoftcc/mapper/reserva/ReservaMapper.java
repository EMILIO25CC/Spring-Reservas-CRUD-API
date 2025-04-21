package com.desoftcc.mapper.reserva;

import com.desoftcc.dto.reservaDTO.ReservaRequestDTO;
import com.desoftcc.dto.reservaDTO.ReservaResponseDTO;
import com.desoftcc.entity.Reserva;
import com.desoftcc.entity.Sala;
import com.desoftcc.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class ReservaMapper {

    public ReservaResponseDTO toDTO (Reserva reserva){
        return ReservaResponseDTO.builder()
                .id(reserva.getId())
                .fechaReserva(reserva.getFechaReserva())
                .horaInicio(reserva.getHoraInicio())
                .horaFin(reserva.getHoraFin())
                .motivo(reserva.getMotivo())
                /// ====================================
                .salaId(reserva.getSala().getId()) /// Ojo para la traer la relación se trae get "sala" y "id"
                .nombreSala(reserva.getSala().getNombre()) // ⚠️OJO
                .usuarioId(reserva.getUsuario().getId())/// Ojo para la traer la relación se trae get "sala" y "id"
                .nombreUsuario(reserva.getUsuario().getNombreCompleto()) //ojito
                /// ====================================
                .build();

    }

    public Reserva toEntity(ReservaRequestDTO requestDTO, Sala sala, Usuario usuario){
        return Reserva.builder()
                .fechaReserva(requestDTO.getFechaReserva())
                .horaInicio(requestDTO.getHoraInicio())
                .horaFin(requestDTO.getHoraFin())
                .motivo(requestDTO.getMotivo())
                /// ===============
                .sala(sala)
                .usuario(usuario)
                /// ===============
                .build();
    }

}
