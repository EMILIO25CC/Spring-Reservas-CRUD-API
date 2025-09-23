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

@Service //Le decimos a Spring: aquí se implementa la lógica de negocio y crea un bean.
@RequiredArgsConstructor //Con esto inicializamos la instancia del mapper y repository.
public class SalaServiceImp implements  SalaService{

    /// Al colocar el final se necesita colocar @RequiredArgsConstructor para que
    /// Spring inicialice estas instancias dentro de la clase y no pueden ser modificadas.
    private final SalaMapper  mapper;
    private final SalaRepository repository;

    /// Listado de Salas.
    public List<SalaResponseDTO> Listar(){
        return repository.findAll()       ///Listar todas las Salas.
                .stream()                /// Iniciamos transformación.
                .map(mapper::toDTO)     ///  Transformando.
                .toList();             ///   Cerrando transformación.
    }
    //________________________________________________

    /// Guardando Sala
    public SalaResponseDTO Guardar(SalaRequestDTO requestDTO){
        Sala sala = mapper.toEntity(requestDTO);     /// Convertimos un DTO a una entidad de tipo Sala.
        Sala salaGuardada = repository.save(sala);  ///  Guardamos la Sala en al BD, con JpaRepository.
        return mapper.toDTO(salaGuardada);         ///   Convertimos la entidad guardada en un DTO y lo retornamos a la API.
    }
    //________________________________________________

    /// Obtener por ID
    public SalaResponseDTO ObtenerPorId(Long id){
        return repository.findById(id)
                .map(mapper::toDTO)
                // Si no se encuentra el usuario, lanza una excepción con el mensaje indicado usando una expresión lambda. (->)
                .orElseThrow(() -> new RuntimeException("La Sala no encontrada."));

    }

    /// __________________________________________ Eliminar.
    public void Eliminar(Long id){
        //Validamos si el Usuario existe para eliminarlo.
        if(!repository.existsById(id)){
            // Si no se encuentra el usuario, lanza una excepción con un mensaje.
            throw new RuntimeException("No existe la Sala con el Id: "+id+".");
        }
        // Eliminamos la Sala de la BD con JpaRepository.
        repository.deleteById(id);


    }
    ///  Fin de Eliminar.

    /// __________________________________________ Obtener Por Id.
    public Sala ObtenerEntidadPorId (Long id){
        return repository.findById(id)
                // Si no se encuentra el usuario, lanza una excepción con el mensaje indicado usando una expresión lambda. (->)
                .orElseThrow(() -> new RuntimeException("Sala no encontrada."));

    }
    ///  Fin de Obtener Por Id.



    /// QUE ES UNA EXPRESIÓN LAMBDA
    /*
     Una expresión lambda es una forma de escribir funciones pequeñas de manera
     más compacta y directa, sin necesidad de crear clases o métodos adicionales.
    _____________________________________________________________________________*/

}/// FIN
