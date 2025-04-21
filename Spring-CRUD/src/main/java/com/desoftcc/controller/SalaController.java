package com.desoftcc.controller;


import com.desoftcc.dto.salaDTO.SalaRequestDTO;
import com.desoftcc.dto.salaDTO.SalaResponseDTO;
import com.desoftcc.service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sala")
public class SalaController {

    private final SalaService salaService;

    @GetMapping
    public List<SalaResponseDTO> listar(){
        return salaService.lista();
    }

    @PostMapping
    public SalaResponseDTO guardar(@RequestBody SalaRequestDTO requestDTO){
        return salaService.guardar(requestDTO);
    }

    @GetMapping("/{id}")
    public SalaResponseDTO obtener(@PathVariable Long id){
        return salaService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar (@PathVariable Long id){
        salaService.eliminar(id);
    }

}//FIN
