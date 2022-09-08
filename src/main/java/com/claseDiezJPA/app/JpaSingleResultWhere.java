package com.claseDiezJPA.app;

import com.claseDiezJPA.app.configuration.JpaUtilDB;
import com.claseDiezJPA.app.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Scanner;

public class JpaSingleResultWhere {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        EntityManager em = JpaUtilDB.getEntityManager();

        Query query = em.createQuery("select c from Cliente c where c.nombre=?1", Cliente.class);

        System.out.println("Ingrese un nombre: ");

        String nombre = s.next();

        query.setParameter(1, nombre);
//        query.setMaxResults(1);

        List<Cliente> c = (List<Cliente>) query.getResultList();
        System.out.println(c);

        em.close();

    }
}
