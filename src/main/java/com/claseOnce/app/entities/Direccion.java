package com.claseOnce.app.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "direcciones")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString

public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "calle", nullable = false, length = 50)
    private String calle;
    @Column(name = "numero", nullable = false)
    private Integer numero;

    public Direccion(String calle, Integer numero) {
        this.calle = calle;
        this.numero = numero;
    }

}
