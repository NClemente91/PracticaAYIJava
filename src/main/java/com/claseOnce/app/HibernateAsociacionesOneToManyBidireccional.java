package com.claseOnce.app;

import com.claseOnce.app.configurations.JpaUtilDB;
import com.claseOnce.app.entities.Cliente;
import com.claseOnce.app.entities.Factura;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class HibernateAsociacionesOneToManyBidireccional {
    public static void main(String[] args) {

        EntityManager em = JpaUtilDB.getEntityManager();

        try {
            em.getTransaction().begin();

            List<Factura> listFactura = new ArrayList<>();

            Cliente cliente = new Cliente("Nico", "Clemente");
            cliente.setFormaPago("PayPal");

            Factura f1 = new Factura("compras de supermercado", 5000);
            Factura f2 = new Factura("compras de tecnologia", 7000);

            listFactura.add(f1);
            listFactura.add(f2);

            cliente.setFacturas(listFactura);

            em.persist(cliente);

            System.out.println(cliente);

            List<Factura> listFactura2 = new ArrayList<>();

            Cliente cliente2 = new Cliente("Leonel", "Altamirano");
            cliente2.setFormaPago("Debito");

            Factura f3 = new Factura("compras de supermercado y frutas", 4000);
            Factura f4 = new Factura("compras de tecnologia y muebles", 2000);

            listFactura2.add(f3);
            listFactura2.add(f4);

            cliente2.setFacturas(listFactura2);

            em.persist(cliente2);
            em.getTransaction().commit();
            System.out.println(cliente2);

            /*em.getTransaction().begin();
            // Factura f3 = em.find(Factura.class, 1L);
            Factura f3 = new Factura("compras de supermercado", 5000L);
            f3.setId(1L);
            cliente.removeFactura(f3);
            em.getTransaction().commit();
            System.out.println(cliente);*/
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
