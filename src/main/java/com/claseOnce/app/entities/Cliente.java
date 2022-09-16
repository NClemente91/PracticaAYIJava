package com.claseOnce.app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString

public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name = "forma_pago", nullable = false, length = 15)
    private String formaPago;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "tbl_clientes_direcciones",
            joinColumns = @JoinColumn(name="id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "id_direccion"),
            uniqueConstraints = @UniqueConstraint(columnNames={"id_direccion"}))
    private List<Direccion> direcciones;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "cliente")
    private List<Factura> facturas;

    @Embedded
    private Auditoria audit = new Auditoria();

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
