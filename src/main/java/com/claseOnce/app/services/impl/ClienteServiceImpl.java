package com.claseOnce.app.services.impl;

import com.claseOnce.app.entities.Cliente;
import com.claseOnce.app.repositories.IBaseRepository;
import com.claseOnce.app.repositories.impl.ClienteRepository;
import com.claseOnce.app.services.IBaseService;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements IBaseService<Cliente> {
    private EntityManager em;
    private IBaseRepository<Cliente> clienteRepository;

    public ClienteServiceImpl(EntityManager em) {
        this.em = em;
        this.clienteRepository = new ClienteRepository(em);
    }

    @Override
    public List<Cliente> findAll() throws Exception {
        try {
            return clienteRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Cliente findById(Long id) throws Exception {
        try {
            Optional<Cliente> clienteById = Optional.ofNullable(clienteRepository.findById(id));
            return clienteById.orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Cliente save(Cliente cliente) throws Exception {
        try {
            em.getTransaction().begin();
            clienteRepository.save(cliente);
            em.getTransaction().commit();
            return cliente;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Cliente update(Long id, Cliente cliente) throws Exception {
        try {
            Optional<Cliente> clienteOptional = Optional.ofNullable(clienteRepository.findById(id));
            clienteOptional.get();
            em.getTransaction().begin();
            clienteRepository.update(cliente);
            em.getTransaction().commit();
            return clienteRepository.findById(id);
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try {
            Optional<Cliente> clienteOptional = Optional.ofNullable(clienteRepository.findById(id));
            clienteOptional.get();
            em.getTransaction().begin();
            clienteRepository.delete(id);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
