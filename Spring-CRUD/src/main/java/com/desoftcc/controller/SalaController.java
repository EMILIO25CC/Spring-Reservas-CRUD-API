package com.desoftcc.controller;


import com.desoftcc.dto.salaDTO.SalaRequestDTO;
import com.desoftcc.dto.salaDTO.SalaResponseDTO;
import com.desoftcc.service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sala")
public class SalaController {

    // Se declara como private final para que solo pueda usarse dentro de esta clase,
    // evitando acceso público que comprometería la lógica específica del controlador y sus DTOs,
    // ya que tiene una lógica única y específica solo para este controller.
    private final SalaService salaService;

    @GetMapping
    public List<SalaResponseDTO> ListarSalas(){
        return salaService.Listar();
    }

    @PostMapping
    public SalaResponseDTO GuardarSala(@RequestBody SalaRequestDTO requestDTO){
        return salaService.Guardar(requestDTO);
    }

    @GetMapping("/{id}")
    public SalaResponseDTO BuscarSala(@PathVariable Long id){
        return salaService.ObtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void EliminarSala (@PathVariable Long id){
        salaService.Eliminar(id);
    }



}// Fin
