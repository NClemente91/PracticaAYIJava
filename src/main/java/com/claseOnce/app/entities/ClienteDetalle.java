package com.claseOnce.app.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clientes_detalles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ClienteDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean prime;
    @Column(name="puntos_acumulados")
    private Long puntosAcumulados;
    @OneToOne
    @JoinColumn(name="cliente_detalle_id")
    private Cliente cliente;

}