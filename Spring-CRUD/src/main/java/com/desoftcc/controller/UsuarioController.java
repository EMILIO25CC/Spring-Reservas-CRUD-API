package com.desoftcc.controller;

import com.desoftcc.dto.usuarioDTO.UsuarioRequestDTO;
import com.desoftcc.dto.usuarioDTO.UsuarioResponseDTO;
import com.desoftcc.service.UsuarioService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioResponseDTO>listar(){
        return  usuarioService.Listar();
    }

    @PostMapping
    public UsuarioResponseDTO guardar(@RequestBody UsuarioRequestDTO requestDTO){
        return usuarioService.Guardar(requestDTO);
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO obtener(@PathVariable Long id){
        return usuarioService.ObtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        usuarioService.Eliminar(id);
    }

}///FIN
