package com.desoftcc.mapper.sala;

import com.desoftcc.dto.salaDTO.SalaRequestDTO;
import com.desoftcc.dto.salaDTO.SalaResponseDTO;
import com.desoftcc.entity.Sala;
import org.springframework.stereotype.Component;

@Component
public class SalaMapper {

    public SalaResponseDTO toDTO (Sala sala){
        return SalaResponseDTO.builder()
                .id(sala.getId())
                .nombre(sala.getNombre())
                .capacidad(sala.getCapacidad())
                .ubicacion(sala.getUbicacion())
                .recursos(sala.getRecursos())
                .disponible(sala.getDisponible())
                .build();
    }

    public Sala toEtity(SalaRequestDTO requestDTO){
        return Sala.builder()
                .nombre(requestDTO.getNombre())
                .capacidad(requestDTO.getCapacidad())
                .ubicacion(requestDTO.getUbicacion())
                .recursos(requestDTO.getRecursos())
                .disponible(requestDTO.getDisponible())
                .build();
    }



}///Fin
