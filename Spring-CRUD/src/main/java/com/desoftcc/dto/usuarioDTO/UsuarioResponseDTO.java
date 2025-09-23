package com.desoftcc.dto.usuarioDTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioResponseDTO {


    private Long id;
    private String nombreCompleto;
    private String email;
    private String telefono;
    private String departamento;


    /// DTO : [ OBJETO DE TRANSFERENCIA DE DATOS ]

}
