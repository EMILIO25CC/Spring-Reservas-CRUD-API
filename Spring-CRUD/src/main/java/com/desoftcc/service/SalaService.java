package com.desoftcc.service;

import com.desoftcc.dto.salaDTO.SalaRequestDTO;
import com.desoftcc.dto.salaDTO.SalaResponseDTO;
import com.desoftcc.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SalaService {
    /// Aquí colocamos los métodos que usara la API para Sala.

    List<SalaResponseDTO> Listar();
    SalaResponseDTO Guardar(SalaRequestDTO requestDTO);

    /// Devuelve un DTO listo para la API, con los datos que se van a exponer al cliente
    SalaResponseDTO ObtenerPorId(Long id);

    void Eliminar(Long id);
    /// Devuelve la entidad completa para uso interno en el backend, útil para relaciones o lógica interna
    Sala ObtenerEntidadPorId(Long id);

    /*
     * Diferencia entre ambos métodos:
     *
     * - UsuarioResponseDTO ObtenerPorId(Long id):
     *   Devuelve solo los datos necesarios para la API,
     *   ocultando información sensible y mostrando únicamente
     *   lo que el cliente debe consumir.
     *
     * - Sala ObtenerEntidadPorId(Long id):
     *   Devuelve la entidad completa.
     *   Se usa únicamente en el backend para lógica interna
     *   o manejo de relaciones con otras entidades.
     */



}/// FIN de la interfaz de Sala.
