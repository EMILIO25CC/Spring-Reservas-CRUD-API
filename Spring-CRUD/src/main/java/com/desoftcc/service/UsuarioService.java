package com.desoftcc.service;

import com.desoftcc.dto.usuarioDTO.UsuarioRequestDTO;
import com.desoftcc.dto.usuarioDTO.UsuarioResponseDTO;
import com.desoftcc.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    List<UsuarioResponseDTO> Listar();

    UsuarioResponseDTO Guardar(UsuarioRequestDTO requestDTO);

    UsuarioResponseDTO ObtenerPorId(Long id);

    void Eliminar(Long id);

    Usuario obtenerEntidadPorId(Long id);
}
