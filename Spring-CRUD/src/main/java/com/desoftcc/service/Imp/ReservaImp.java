package com.desoftcc.service.Imp;

import com.desoftcc.dto.reservaDTO.ReservaRequestDTO;
import com.desoftcc.dto.reservaDTO.ReservaResponseDTO;
import com.desoftcc.entity.Reserva;
import com.desoftcc.entity.Sala;
import com.desoftcc.entity.Usuario;
import com.desoftcc.mapper.reserva.ReservaMapper;
import com.desoftcc.repository.ReservaRepository;
import com.desoftcc.service.ReservaService;
import com.desoftcc.service.SalaService;
import com.desoftcc.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaImp implements ReservaService {

    private final ReservaMapper mapper;
    private final ReservaRepository repository;
    /// -------- Porque esto une ambas entidades
    private final UsuarioService usuarioService;
    private final SalaService salaService;
    /// -----------------------------------------

    @Override
    public List<ReservaResponseDTO> Listar() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public ReservaResponseDTO gardar(ReservaRequestDTO requestDTO) {
        Sala sala = salaService.obtenerEntidadPorID(requestDTO.getSalaId());
        Usuario usuario = usuarioService.obtenerEntidadPorId(requestDTO.getUsuarioId());
        boolean hayCruce = repository.existsBySalaAndFechaReservaAndHoraInicioLessThanAndHoraFinGreaterThan(sala,
                requestDTO.getFechaReserva(),
                requestDTO.getHoraFin(),
                requestDTO.getHoraInicio());
        if (hayCruce){
            throw new RuntimeException("La sala ya esta reservada en ese horario");
        }
        Reserva reserva = mapper.toEntity(requestDTO,sala,usuario);
        Reserva reservaGuardada = repository.save(reserva);
        return  mapper.toDTO(reservaGuardada);

    }

    @Override
    public ReservaResponseDTO obtenerPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(()-> new RuntimeException("Reserva NO encontrada"));
    }

    @Override
    public void eliminar(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("No existe uan reserva con ID"+id);
        }
        repository.deleteById(id);
    }

}//FIN
