package com.desoftcc.mapper.sala;

import com.desoftcc.dto.salaDTO.SalaRequestDTO;
import com.desoftcc.dto.salaDTO.SalaResponseDTO;
import com.desoftcc.entity.Sala;
import org.springframework.stereotype.Component;


/// Esto nos permitirá crear una instancia en cualquier parte ya qué inicializa los métodos y la clase.
@Component
public class SalaMapper {

    // Vamos a llamar a SalaResponseDTO y SalaRequestDTO
    // para convertir mi entidad Sala en un ResponseDTO
    // y convertir mi RequestDTO a una entidad.

    /// Convertir una entidad de tipo Sala a un DTO Response.
    public SalaResponseDTO toDTO (Sala sala){
        return SalaResponseDTO.builder()
                .id(sala.getId())
                .nombre(sala.getNombre())
                .capacidad(sala.getCapacidad())
                .ubicacion(sala.getUbicacion())
                .recursos(sala.getRecursos())
                .build();

    }///fin

    /// Convertir un DTO Request a una entidad de tipo Sala.
    public Sala toEntity(SalaRequestDTO requestDTO){
        return Sala.builder()
                .nombre(requestDTO.getNombre())
                .capacidad(requestDTO.getCapacidad())
                .ubicacion(requestDTO.getUbicacion())
                .recursos(requestDTO.getRecursos())
                .disponible(requestDTO.getDisponible())
                .build();
    }///fin


}/// End.

