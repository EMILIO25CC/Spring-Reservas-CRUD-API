package com.desoftcc.service;

import com.desoftcc.dto.salaDTO.SalaRequestDTO;
import com.desoftcc.dto.salaDTO.SalaResponseDTO;
import com.desoftcc.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaService  {

    List<SalaResponseDTO> lista();

    SalaResponseDTO guardar(SalaRequestDTO requestDTO);

    SalaResponseDTO obtenerPorId(Long id);
    void eliminar (Long id);

    ///OJO
    Sala obtenerEntidadPorID(Long id);

}
