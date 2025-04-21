package com.desoftcc.service;

import com.desoftcc.dto.reservaDTO.ReservaRequestDTO;
import com.desoftcc.dto.reservaDTO.ReservaResponseDTO;

import java.util.List;

public interface ReservaService {

    List<ReservaResponseDTO>Listar();

    ReservaResponseDTO gardar (ReservaRequestDTO requestDTO);

    ReservaResponseDTO obtenerPorId(Long id);

    void eliminar(Long id);
}
