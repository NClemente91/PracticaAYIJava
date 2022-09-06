package com.claseDiezJPA.app;

import com.claseDiezJPA.app.configuration.JpaUtilDB;
import com.claseDiezJPA.app.entity.Cliente;
import jakarta.persistence.EntityManager;

import java.util.List;

public class JpaListar {
    public static void main(String[] args) {

        System.out.println("JPA");

        EntityManager em = JpaUtilDB.getEntityManager();

        List<Cliente> clientes = em.createQuery("select c from Cliente c", Cliente.class).getResultList();

        for(Cliente listCliente:clientes){
            System.out.println("Lista cliente: " + listCliente.toString());
        }

        //Similar a lo de arriba
        //clientes.forEach(System.out::println);

        em.close();

    }
}
