package com.desoftcc.controller;

import com.desoftcc.dto.reservaDTO.ReservaRequestDTO;
import com.desoftcc.dto.reservaDTO.ReservaResponseDTO;
import com.desoftcc.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @GetMapping
    public List<ReservaResponseDTO> listar(){
        return reservaService.Listar();
    }

    @PostMapping
    public ReservaResponseDTO guardar(@RequestBody ReservaRequestDTO requestDTO){
        return reservaService.gardar(requestDTO);
    }

    @GetMapping("/{id}")
    public ReservaResponseDTO obtener(@PathVariable Long id){
        return reservaService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        reservaService.eliminar(id);
    }

}//FIN
