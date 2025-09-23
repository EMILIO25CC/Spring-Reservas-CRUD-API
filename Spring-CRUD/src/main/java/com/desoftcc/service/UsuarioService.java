package com.desoftcc.service;

import com.desoftcc.dto.usuarioDTO.UsuarioRequestDTO;
import com.desoftcc.dto.usuarioDTO.UsuarioResponseDTO;
import com.desoftcc.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    /// Aquí colocamos los métodos que usara la API para Usuario.

    List<UsuarioResponseDTO> Listar();
    UsuarioResponseDTO Guardar(UsuarioRequestDTO requestDTO);
    UsuarioResponseDTO ObtenerPorId(Long id);

    void Eliminar(Long id);
    Usuario ObtenerEntidadPorId(Long id);

}// FIN de la interfaz
