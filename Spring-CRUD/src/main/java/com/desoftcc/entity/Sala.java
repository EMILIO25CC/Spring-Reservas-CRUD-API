package com.desoftcc.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder // permite construir objetos con la sintaxis
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer capacidad;
    private String ubicacion;
    private String recursos;
    private Boolean disponible;

    /// Una sala tiene muchas reservas
    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;


}///FIN
