package com.taller.inventario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Entity le dice a Spring: "Oye, esta clase es una tabla en la base de datos"
@Entity
// @Data es de Lombok: Genera automáticamente los Getters, Setters y ToString (para no escribirlos a mano)
@Data
// @NoArgsConstructor y @AllArgsConstructor generan los constructores vacíos y con parámetros
@NoArgsConstructor
@AllArgsConstructor
public class Repuesto {

    // @Id dice que esta columna es la clave primaria
    @Id
    // @GeneratedValue hace que el ID se auto-incremente (1, 2, 3...) sin que tú lo escribas
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String categoria; // Ej: "Frenos", "Motor", "Suspensión"
    private Double precio;
    private Integer stock; // Cantidad disponible en el taller
}