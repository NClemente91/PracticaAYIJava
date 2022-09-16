package com.claseOnce.app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "facturas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "total")
    private Integer total;

    @ManyToOne
    private Cliente cliente;

    public Factura(String descripcion, Integer total) {
        this.descripcion = descripcion;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", total=" + total +
                ", id_cliente=" + cliente +
                '}';
    }
}
