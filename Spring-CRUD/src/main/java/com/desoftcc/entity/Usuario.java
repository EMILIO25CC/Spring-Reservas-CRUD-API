package com.desoftcc.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;

    @Column(unique = true, nullable = false) // el campo sera unico y llenado obligatoriamente.
    private String email;

    private String telefono;

    private String departamento;

    /// Un Usuario puede tener Muchas Reservas
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Reserva> reservas;

}//Fin de la clase Usuario.
