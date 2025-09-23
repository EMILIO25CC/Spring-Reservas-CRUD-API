package com.desoftcc.service;

import com.desoftcc.dto.reservaDTO.ReservaRequestDTO;
import com.desoftcc.dto.reservaDTO.ReservaResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReservaService {

    /// Aquí colocamos los métodos que usara la API para Reserva.

    List<ReservaResponseDTO> Listar();
    ReservaResponseDTO Guardar(ReservaRequestDTO requestDTO);
    ReservaResponseDTO ObtenerPorId(Long id);

    void Eliminar(Long id);

}///Fin
