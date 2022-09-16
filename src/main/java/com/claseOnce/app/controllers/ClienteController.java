package com.claseOnce.app.controllers;

import com.claseOnce.app.entities.Cliente;
import com.claseOnce.app.services.IBaseService;
import com.claseOnce.app.services.impl.ClienteServiceImpl;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteController {
    private EntityManager em;
    private IBaseService<Cliente> clienteService;

    public ClienteController(EntityManager em) {
        this.em = em;
        this.clienteService = new ClienteServiceImpl(em);
    }

    public List<Cliente> getCLientes() throws Exception {
        return clienteService.findAll();
    }

    public Cliente getClienteById(Long id) throws Exception {
        return clienteService.findById(id);
    }

    public Cliente createCliente(Cliente cliente) throws Exception {
        return clienteService.save(cliente);
    }

    public Cliente updateCliente(Long id, Cliente cliente) throws Exception {
        return clienteService.update(id, cliente);
    }

    public boolean deleteCliente(Long id) throws Exception {
        return  clienteService.delete(id);
    }
}
