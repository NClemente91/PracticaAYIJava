package com.claseDiezJPA.app;

import com.claseDiezJPA.app.configuration.JpaUtilDB;
import com.claseDiezJPA.app.entity.Cliente;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Scanner;

public class JpaEditar {

    public static void main(String[] args) {

        EntityManager em = JpaUtilDB.getEntityManager();

        try{

            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingrese el id del cliente a modificar:"));
            Cliente c = em.find(Cliente.class, id);
            if(c == null) {
                System.out.println("Objeto cliente nulo");
            } else {

                String nombre = JOptionPane.showInputDialog("Ingrese el nombre:", c.getNombre());
                String apellido = JOptionPane.showInputDialog("Ingrese el apellido:", c.getApellido());
                String pago = JOptionPane.showInputDialog("Ingrese la forma de pago:", c.getFormaPago());

                em.getTransaction().begin();

                c.setNombre(nombre);
                c.setApellido(apellido);
                c.setFormaPago(pago);
                c.setFechaCreacion(LocalDate.now());
                System.out.println("Id del cliente: " + c.getId());
                em.merge(c);
                System.out.println("Cliente actualizado " + c);

                em.getTransaction().commit();
            }
        } catch(Exception ex){
            em.getTransaction().rollback();
            ex.getMessage();
        } finally {
            em.close();
        }

    }
}
