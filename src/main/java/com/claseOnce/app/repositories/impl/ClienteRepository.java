package com.claseOnce.app.repositories.impl;

import com.claseOnce.app.entities.Cliente;
import com.claseOnce.app.repositories.IBaseRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteRepository implements IBaseRepository<Cliente> {

    private EntityManager em;

    public ClienteRepository(EntityManager em) {
        this.em = em;
    }

    //Transacciones básicas, no piensan, cuando llega acá es porque se puede aplicar

    @Override
    public List<Cliente> findAll() {
        return em.createQuery("select c from Cliente c", Cliente.class).getResultList();
    }

    @Override
    public Cliente findById(Long id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public void save(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        em.merge(cliente);
    }

    @Override
    public void delete(Long id) {
        Cliente cliente = findById(id);
        em.remove(cliente);
    }
}
