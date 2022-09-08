package com.claseDiezJPA.app;

import com.claseDiezJPA.app.configuration.JpaUtilDB;
import com.claseDiezJPA.app.entity.Cliente;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class JpaPorId {
    public static void main(String[] args) {

        EntityManager em = JpaUtilDB.getEntityManager();

        Scanner s = new Scanner(System.in);

        System.out.println("Ingrese el id: ");
        Long id = s.nextLong();

        Cliente cliente = em.find(Cliente.class, id);
        System.out.println(cliente);

        Cliente cliente2 = em.find(Cliente.class, id);
        System.out.println(cliente2);

        em.close();

    }
}
