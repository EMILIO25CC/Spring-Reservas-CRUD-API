package com.desoftcc.service.Imp;

import com.desoftcc.dto.usuarioDTO.UsuarioRequestDTO;
import com.desoftcc.dto.usuarioDTO.UsuarioResponseDTO;
import com.desoftcc.entity.Usuario;
import com.desoftcc.mapper.usuario.UsuarioMapper;
import com.desoftcc.repository.UsuarioRepository;
import com.desoftcc.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Le decimos a Spring: aquí se implementa la lógica de negocio y crea un bean.
@RequiredArgsConstructor //Con esto inicializamos la instancia del mapper y repository.
public class UsuarioServiceImp implements UsuarioService {

    /// Al colocar el final se necesita colocar @RequiredArgsConstructor para que
    /// Spring inicialice estas instancias dentro de la clase y no pueden ser modificadas.
    private final UsuarioMapper mapper;
    private final UsuarioRepository repository;

    /// Listar ___________________________________________
    public List<UsuarioResponseDTO> Listar(){
        return repository.findAll()      /// Metodo heredado de JpaRepository (proviene de CrudRepository).
                .stream()               /// Abre un flujo para procesar cada elemento de la lista (map, filter, sorted, etc.).
                .map(mapper::toDTO)    /// Convierte cada entidad Usuario en su respectivo DTO.
                .toList();            /// Cierra el stream y empaqueta el resultado en una nueva lista para la API.
    }

    /// Fin listar.

    /// __________________________________________ Guardar.
    public UsuarioResponseDTO Guardar(UsuarioRequestDTO requestDTO){
        // Validamos que no exista un usuario con el mismo email.
        if(repository.existsByEmail(requestDTO.getEmail())){
            // Si el email ya existe en la BD, detenemos el flujo y lanzamos excepción.
            throw new RuntimeException("El Email ya está registrado.");// Si se cumple throw new RuntimeException Lanza una nueva excepción en tiempo de ejecución.
        }
        // Convertimos el DTO recibido en una entidad Usuario.
        Usuario usuario = mapper.toEntity(requestDTO);
        // Guardamos la entidad en la base de datos usando JpaRepository.
        Usuario usuarioGuardado = repository.save(usuario);
        // Convertimos la entidad guardada en un DTO y lo retornamos a la API.
        return mapper.toDTO(usuarioGuardado);
    }

    /// Fin guardar.


    /// __________________________________________ Obtener Por Id.
    public UsuarioResponseDTO ObtenerPorId(Long id){
        return repository.findById(id)
                .map(mapper::toDTO)
                // Si no se encuentra el usuario, lanza una excepción con el mensaje indicado usando una expresión lambda. (->)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado."));
    }

    ///  Fin de Obtener Por Id.


    /// __________________________________________ Eliminar.
    public void Eliminar(Long id){
        //Validamos si el Usuario existe para eliminarlo.
        if(!repository.existsById(id)){
            // Si no se encuentra el usuario, lanza una excepción con un mensaje.
            throw new RuntimeException("No existe un Usuario con Id: "+ id +".");
        }
        //Eliminamos al Usuario de la BD con JpaRepository.
        repository.deleteById(id);
    }
    ///  Fin de Eliminar.

    /// __________________________________________ Obtener Entidad Por ID.
    public Usuario ObtenerEntidadPorId(Long id){
        return repository.findById(id) // Búscamos por ID con JpaRepository, para ver si está en la DB.
                // Si no se encuentra el usuario, lanza una excepción con el mensaje indicado usando una expresión lambda. (->)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado."));
    }


    ///  Fin de Obtener Entidad Por ID.



    /// QUE ES UNA EXPRESIÓN LAMBDA
    /*
     Una expresión lambda es una forma de escribir funciones pequeñas de manera
     más compacta y directa, sin necesidad de crear clases o métodos adicionales.
    _____________________________________________________________________________*/


}/// FIN