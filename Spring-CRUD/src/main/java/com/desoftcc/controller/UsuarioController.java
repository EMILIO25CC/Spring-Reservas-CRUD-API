package com.desoftcc.controller;

import com.desoftcc.dto.usuarioDTO.UsuarioRequestDTO;
import com.desoftcc.dto.usuarioDTO.UsuarioResponseDTO;
import com.desoftcc.service.UsuarioService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // Lombok genera el constructor con los atributos "final".
@RestController         // Marca la clase como controlador REST, gestionando peticiones HTTP y devolviendo JSON.
@RequestMapping("/api/usuario")//  Define la URL base para acceder a los endpoints de Usuarios.
public class UsuarioController {

    // Inyección de dependencias:
    // Se inyecta la interfaz UsuarioService que está implementada en UsuarioServiceImp.
    // Aquí solo delegamos la lógica, no implementamos nada en el controlador.
    private final UsuarioService usuarioService;

    //Listado de Usuarios.
    @GetMapping
    public List<UsuarioResponseDTO> ListarUsuario() {
        return usuarioService.Listar();
    }///________________________________________________________________

    //Guardar Usuarios.
    @PostMapping
    public UsuarioResponseDTO GuardarUsuario(@RequestBody UsuarioRequestDTO requestDTO){
        return usuarioService.Guardar(requestDTO);
    }///________________________________________________________________

    //Buscar Usuarios
    @GetMapping("/{id}")
    public UsuarioResponseDTO BuscarUsuario(@PathVariable Long id){
        return usuarioService.ObtenerPorId(id);
    }///________________________________________________________________

    //Eliminar Usuarios
    @DeleteMapping("{id}")
    public void EliminarUsuario(@PathVariable Long id){
        //Por regla general un void no lleva un return,
        // porque cumple una acción sin devolver nada.
        usuarioService.Eliminar(id);
    }///________________________________________________________________


    /// INFORMACIÓN DE ANOTACIONES IMPLEMENTADAS
    /*
        @RequestBody: Indica que el parámetro del metodo se obtiene del cuerpo (body) de la petición HTTP.
                      Se usa normalmente en POST/PUT para recibir JSON y convertirlo en un objeto Java.

        @PathVariable: Vincula una variable de la URL (ejemplo: /api/usuario/5) con un parámetro del metodo.
                       Sirve para capturar ID's u otros datos pasados en la ruta.
    */


}//Fin

