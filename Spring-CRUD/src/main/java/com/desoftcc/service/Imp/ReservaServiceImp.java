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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaServiceImp implements ReservaService {

    //El final requiere @RequiredArgsConstructor
    private final ReservaMapper mapper;
    private final ReservaRepository repository;
    /// Traemos los services de Usuario y Sala.
    private final UsuarioService usuarioService;
    private final SalaService salaService;

    ///  Listar Reservas
    public List<ReservaResponseDTO> Listar(){       ///1 Función de Listado.
        return repository.findAll()                ///2  Listar con JpaRepository.
                .stream()                         ///3   Iniciando Transformación.
                .map(mapper::toDTO)              ///4    Transformando.
                .toList();                      ///5     Cerrando Transformación.
    }

    /// __________________________________________ Guardar Reserva [14/09/2025] -> DeSofCC
    public ReservaResponseDTO Guardar(ReservaRequestDTO requestDTO){

        // 1. Obtención de dependencias (Sala y Usuario).
        //    Se valida implícitamente su existencia mediante los métodos de servicio,
        //    que lanzan excepción si no encuentran la entidad correspondiente.
        Sala sala = salaService.ObtenerEntidadPorId(requestDTO.getSalaId());
        Usuario usuario = usuarioService.ObtenerEntidadPorId(requestDTO.getUsuarioId());

        // 2. Validación de disponibilidad (cruce de horarios).
        //    La consulta del repository verifica si ya existe una reserva en la misma sala, fecha y rango de hora
        boolean HayCruce = repository.existsBySalaAndFechaReservaAndHoraInicioLessThanAndHoraFinGreaterThan(
                sala,
                requestDTO.getFechaReserva(),
                requestDTO.getHoraInicio(),
                requestDTO.getHoraFin()
        );

        // 3. Manejo de conflicto: si hay cruce de horarios, se lanza excepción.
        if(HayCruce){
            throw new RuntimeException("La Sala ya está reservada en ese horario.");
        }

        // 4. Conversión del DTO a Entidad.
        //    El mapper se encarga de construir la entidad Reserva a partir del DTO recibido
        //    y las entidades relacionadas (Sala y Usuario).
        Reserva reserva = mapper.toEntity(requestDTO, sala, usuario);

        // 5. Persistencia en la base de datos.
        //    Se guarda la nueva reserva en el repositorio (BD).
        Reserva nuevaReserva = repository.save(reserva);

        // 6. Conversión de la entidad persistida a DTO de respuesta.
        //    Esto asegura que el controlador reciba solo la información necesaria.
        return mapper.toDTO(nuevaReserva);
    }
    /// __________________________________________ Fin de Guardar Reserva



    /// Obtener Reserva por ID
    public ReservaResponseDTO ObtenerPorId(Long id){
        return repository.findById(id)
                .map(mapper::toDTO)
                // Si no se encuentra el usuario, lanza una excepción con el mensaje indicado usando una expresión lambda. (->)
                .orElseThrow(()-> new RuntimeException("Reserva no encontrada."));
    }

    /// Eliminar Reserva por ID
    public void Eliminar(Long id){
        //Aplicamos una condición, para verificar existencia.
        if(!repository.existsById(id)){
            //Mensaje de excepción si no se encontró la reserva.
            throw new RuntimeException("Reserva no encontrada con ID: "+id+".");
        }
        //Eliminamos la Reserva de la BD, con JpaRepository.
        repository.deleteById(id);
    }

    /// QUE ES UNA EXPRESIÓN LAMBDA
    /*
     Una expresión lambda es una forma de escribir funciones pequeñas de manera
     más compacta y directa, sin necesidad de crear clases o métodos adicionales.
    _____________________________________________________________________________*/

}/// Fin
