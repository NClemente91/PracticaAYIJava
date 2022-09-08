package com.claseDiezJPA.app.repositories.impl;

import com.claseDiezJPA.app.entity.Cliente;
import com.claseDiezJPA.app.repositories.IClienteRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

//Transacciones básicas, no piensan, cuando llega acá es porque se puede aplicar
public class ClienteRepository implements IClienteRepository {

    private EntityManager em;

    public ClienteRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Cliente> listar() {
        return em.createQuery("select c from Cliente c", Cliente.class).getResultList();
    }

    @Override
    public Cliente getById(Long id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public void insertar(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void actualizar(Cliente cliente) {
        em.merge(cliente);
    }

    @Override
    public void eliminar(Long id) {
        Cliente cliente = getById(id);
        em.remove(cliente);
    }
}
