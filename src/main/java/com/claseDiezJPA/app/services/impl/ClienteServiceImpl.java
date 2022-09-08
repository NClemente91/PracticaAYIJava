package com.claseDiezJPA.app.services.impl;

import com.claseDiezJPA.app.entity.Cliente;
import com.claseDiezJPA.app.repositories.IClienteRepository;
import com.claseDiezJPA.app.repositories.impl.ClienteRepository;
import com.claseDiezJPA.app.services.IClienteService;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements IClienteService {

    private EntityManager em;
    private IClienteRepository<Cliente> iClienteRepository;

    public ClienteServiceImpl(EntityManager em) {
        this.em = em;
        this.iClienteRepository = new ClienteRepository(em);
    }

    @Override
    public List<Cliente> getAll() {
        return iClienteRepository.listar();
    }

    @Override
    public Optional<Cliente> getById(Long id) {
        //Te permite opciones de validacion mas complejas
        Optional<Cliente> clienteById;
        clienteById = Optional.ofNullable(iClienteRepository.getById(id));

        if (clienteById.isPresent()) {
            return clienteById;
        } else {
            return null;
        }

    }

    @Override
    public void eliminar(Long id) {

        Optional<Cliente> clienteById;
        clienteById = Optional.ofNullable(iClienteRepository.getById(id));

        if (clienteById.isPresent()) {
            try {
                em.getTransaction().begin();
                iClienteRepository.eliminar(id);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
            }
        } else {
            System.out.println("No se pudo borrar, no existe");
        }
    }

    @Override
    public void insert(Cliente cliente) {
        try {
            em.getTransaction().begin();
            iClienteRepository.insertar(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void guardar(Cliente cliente) {

        if (cliente.getId() > 0) {

            Optional<Cliente> clienteById;
            clienteById = Optional.ofNullable(iClienteRepository.getById(cliente.getId()));

            if(clienteById.isPresent()){
                try {
                    em.getTransaction().begin();
                    iClienteRepository.actualizar(cliente);
                    em.getTransaction().commit();
                } catch (Exception e) {
                    em.getTransaction().rollback();
                    e.printStackTrace();
                }
            } else {
                System.out.println("El cliente actualizar no existe");
            }

        }
    }
}
