package com.claseDiezJPA.app;

import com.claseDiezJPA.app.configuration.JpaUtilDB;
import com.claseDiezJPA.app.entity.Cliente;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Date;

public class JpaCrear {
    public static void main(String[] args) {

        EntityManager em = JpaUtilDB.getEntityManager();

        try{

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
            String pago = JOptionPane.showInputDialog("Ingrese la forma de pago:");

            em.getTransaction().begin();

            Cliente clienteInsertar = new Cliente();
            clienteInsertar.setNombre(nombre);
            clienteInsertar.setApellido(apellido);
            clienteInsertar.setFormaPago(pago);
            clienteInsertar.setFechaCreacion(LocalDate.now());

            em.persist(clienteInsertar);
            System.out.println("Cliente guardado satisfactoriamente en BD");

            em.getTransaction().commit();

        } catch(Exception ex){
            em.getTransaction().rollback();
            ex.getMessage();
        } finally {
            em.close();
        }
    }
}
