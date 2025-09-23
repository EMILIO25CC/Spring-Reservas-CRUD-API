package com.desoftcc.controller;

import com.desoftcc.dto.reservaDTO.ReservaRequestDTO;
import com.desoftcc.dto.reservaDTO.ReservaResponseDTO;
import com.desoftcc.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @GetMapping
    public List<ReservaResponseDTO> ListarReservas(){
        return reservaService.Listar();
    }

    @PostMapping
    public ReservaResponseDTO GuardarReserva(@RequestBody ReservaRequestDTO requestDTO){
        return reservaService.Guardar(requestDTO);
    }

    @GetMapping("/{id}")
    public ReservaResponseDTO BuscarReserva(@PathVariable Long id){
        return reservaService.ObtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void EliminarReserva(@PathVariable Long id){
        reservaService.Eliminar(id);
    }


}// Fin
