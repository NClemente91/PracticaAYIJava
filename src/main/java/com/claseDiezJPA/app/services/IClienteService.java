package com.claseDiezJPA.app.services;

import com.claseDiezJPA.app.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    List<Cliente> getAll();

    Optional<Cliente> getById(Long id);

    void eliminar(Long id);

    void insert(Cliente cliente);

    void guardar(Cliente cliente);
}
