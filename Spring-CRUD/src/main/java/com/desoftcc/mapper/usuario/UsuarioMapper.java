package com.desoftcc.mapper.usuario;

import com.desoftcc.dto.usuarioDTO.UsuarioRequestDTO;
import com.desoftcc.dto.usuarioDTO.UsuarioResponseDTO;
import com.desoftcc.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioResponseDTO toDTO(Usuario usuario){
        return UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .nombreCompleto(usuario.getNombreCompleto())
                .email(usuario.getEmail())
                .telefono(usuario.getTelefono())
                .departamento(usuario.getDepartamento())
                .build();

    }

    public Usuario toEntity(UsuarioRequestDTO requestDTO){
        return Usuario.builder()
                .nombreCompleto(requestDTO.getNombreCompleto())
                .email(requestDTO.getEmail())
                .telefono(requestDTO.getTelefono())
                .departamento(requestDTO.getDepartamento())
                .build();
    }




}///FIN
