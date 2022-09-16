package com.claseOnce.app;

import com.claseOnce.app.configurations.JpaUtilDB;
import com.claseOnce.app.entities.Cliente;
import com.claseOnce.app.entities.Direccion;
import com.claseOnce.app.entities.Factura;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class MainOneToManyBidireccional {

    public static void main(String[] args) {
        System.out.println("Asociaciones - One to Many Bidireccional");

        EntityManager em = JpaUtilDB.getEntityManager();

        try{
            em.getTransaction().begin();

            List<Factura> listaFacturasCliente1 = new ArrayList<>();
            List<Factura> listaFacturasCliente2 = new ArrayList<>();

            Cliente cliente1 = new Cliente("Germán", "Furfori");
            cliente1.setFormaPago("PayPal");
            Cliente cliente2 = new Cliente("Silvia", "Otaka");
            cliente2.setFormaPago("MercadoPago");

            em.persist(cliente1);
            em.persist(cliente2);

            Factura factura1 = new Factura("Compra en celular", 1000);
            factura1.setCliente(cliente1);
            Factura factura2 = new Factura("Compra de computadora", 2000);
            factura2.setCliente(cliente1);
            Factura factura3 = new Factura("Compra de televisor", 1500);
            factura3.setCliente(cliente2);

            em.persist(factura1);
            em.persist(factura2);
            em.persist(factura3);

            listaFacturasCliente1.add(factura1);
            listaFacturasCliente1.add(factura2);
            listaFacturasCliente2.add(factura3);

            cliente1.setFacturas(listaFacturasCliente1);
            cliente2.setFacturas(listaFacturasCliente2);

            em.merge(cliente1);
            em.merge(cliente2);

            em.getTransaction().commit();

            Cliente cliente = em.find(Cliente.class, 1L);

            System.out.println(cliente);

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}
