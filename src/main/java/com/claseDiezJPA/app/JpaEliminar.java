package com.claseDiezJPA.app;

import com.claseDiezJPA.app.configuration.JpaUtilDB;
import com.claseDiezJPA.app.entity.Cliente;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class JpaEliminar {

    public static void main(String[] args) {

        EntityManager em = JpaUtilDB.getEntityManager();

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el id del cliente a eliminar: ");
        Long id = s.nextLong();

        try{

            Cliente clienteEliminar = em.find(Cliente.class, id);
            if(clienteEliminar == null) {
                System.out.println("Objeto cliente nulo");
            }

            em.getTransaction().begin();

            em.remove(clienteEliminar);
            System.out.println("Cliente eliminado correctamente");

            em.getTransaction().commit();

        } catch(Exception ex){
            em.getTransaction().rollback();
            ex.getMessage();
        } finally {
            em.close();
        }

    }

}
