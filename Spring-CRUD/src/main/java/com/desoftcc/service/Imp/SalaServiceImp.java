package com.desoftcc.service.Imp;

import com.desoftcc.dto.salaDTO.SalaRequestDTO;
import com.desoftcc.dto.salaDTO.SalaResponseDTO;
import com.desoftcc.entity.Sala;
import com.desoftcc.mapper.sala.SalaMapper;
import com.desoftcc.repository.SalaRepository;
import com.desoftcc.service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaServiceImp implements SalaService {

    private final SalaMapper mapper;
    private final SalaRepository repository;

    @Override
    public List<SalaResponseDTO> lista() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();

    }

    @Override
    public SalaResponseDTO guardar(SalaRequestDTO requestDTO) {
        Sala sala = mapper.toEtity(requestDTO);
        Sala salaGuardada = repository.save(sala);
        return mapper.toDTO(salaGuardada);
    }

    @Override
    public SalaResponseDTO obtenerPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(()-> new RuntimeException("Sala no encontrada"));
    }

    @Override
    public void eliminar(Long id) {
        if(repository.existsById(id)){
            throw new RuntimeException("No existe sala con:"+id);
        }
        repository.deleteById(id);
    }

    @Override
    public Sala obtenerEntidadPorID(Long id) {
        return repository.findById(id)
                         .orElseThrow(() -> new RuntimeException("Sala no encontrada"));
    }
}
