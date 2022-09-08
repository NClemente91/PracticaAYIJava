package com.claseDiezJPA.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name = "forma_pago", nullable = false, length = 15)
    private String formaPago;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    public Cliente(String nombre, String apellido, String formaPago, LocalDate fechaCreacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.formaPago = formaPago;
        this.fechaCreacion = fechaCreacion;
    }
}
