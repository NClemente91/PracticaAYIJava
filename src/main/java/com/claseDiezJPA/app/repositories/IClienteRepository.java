package com.claseDiezJPA.app.repositories;

import com.claseDiezJPA.app.entity.Cliente;

import java.util.List;

public interface IClienteRepository<T> {

    List<Cliente> listar();

    Cliente getById(Long id);

    void insertar(Cliente cliente);

    void actualizar(Cliente cliente);

    void eliminar(Long id);
}
