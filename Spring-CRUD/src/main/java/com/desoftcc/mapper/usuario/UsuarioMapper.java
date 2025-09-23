package com.desoftcc.mapper.usuario;

import com.desoftcc.dto.usuarioDTO.UsuarioRequestDTO;
import com.desoftcc.dto.usuarioDTO.UsuarioResponseDTO;
import com.desoftcc.entity.Usuario;
import org.springframework.stereotype.Component;

/// Un Bean es un objeto que spring usan en su línea de contexto, para utilizar una instancia de ota parte.
@Component /// Es para crear una instancia de esta clase (está administrada por Spring)
public class UsuarioMapper {

    /// El objetivo del Mapper manual que estamos implementando es para
    ///
    /// Convergir y adaptar un DTO co una entidad para mostrar respuestas
    /// y formularios al cliente.

    public UsuarioResponseDTO toDTO(Usuario usuario){
        return UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .nombreCompleto(usuario.getNombreCompleto())
                .email(usuario.getEmail())
                .telefono(usuario.getTelefono())
                .departamento(usuario.getDepartamento())
                .build();
    }/// Esto es para convertir una entidad a un DTO para mostrar al cliente, cubriendo información según corresponda.

    public Usuario toEntity(UsuarioRequestDTO requestDTD){
        return Usuario.builder()
                .nombreCompleto(requestDTD.getNombreCompleto())
                .email(requestDTD.getEmail())
                .telefono(requestDTD.getTelefono())
                .departamento(requestDTD.getDepartamento())
                .build();
    }/// Esto es para convertir un DTO a un objeto Usuario, a través de una petición Request.

}/// FIN
