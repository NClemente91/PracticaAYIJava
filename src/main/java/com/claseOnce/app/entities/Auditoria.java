package com.claseOnce.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
public class Auditoria {
    @Column(name = "creado_en")
    private LocalDateTime creadoEn;
    @Column(name = "editado_en")
    private LocalDateTime editadoEn;

    @PrePersist
    public void prePersist() {
        System.out.println("inicializar algo justo antes del persist");
        this.creadoEn = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate() {
        System.out.println("inicializar algo justo antes del update");
        this.editadoEn = LocalDateTime.now();
    }
}