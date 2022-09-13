package com.claseOnce.app;

import com.claseOnce.app.configurations.JpaUtilDB;
import com.claseOnce.app.entities.Cliente;
import com.claseOnce.app.entities.Direccion;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Asociaciones");

        EntityManager em = JpaUtilDB.getEntityManager();

        try{

            Cliente cliente1;
            em.getTransaction().begin();

            cliente1 = new Cliente("Nico", "Clemente");
            cliente1.setFormaPago("Efectivo");

            Direccion direccion1 = new Direccion("Belgrano", 2021);
            Direccion direccion2 = new Direccion("San Martin", 1347);

            List<Direccion> listaDirecciones = new ArrayList<>();
            listaDirecciones.add(direccion1);
            listaDirecciones.add(direccion2);

            cliente1.setDirecciones(listaDirecciones);

            em.persist(cliente1);

            em.getTransaction().commit();

            cliente1 = em.find(Cliente.class, cliente1.getId());

            System.out.println(cliente1);

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
