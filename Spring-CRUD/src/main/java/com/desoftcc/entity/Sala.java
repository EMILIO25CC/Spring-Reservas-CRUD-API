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
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer capacidad;
    private String ubicacion;
    private String recursos;
    private Boolean disponible;


    /// Una Sala tiene muchas Reservas
    @OneToMany(mappedBy = "sala",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Reserva> reservas;


}
