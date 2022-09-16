package com.claseOnce.app;

import com.claseOnce.app.configurations.JpaUtilDB;
import com.claseOnce.app.entities.Alumno;
import com.claseOnce.app.entities.Curso;
import jakarta.persistence.EntityManager;


public class HibernateAsociacionesManyToMany {
    public static void main(String[] args) {

        EntityManager em = JpaUtilDB.getEntityManager();

        try {
            em.getTransaction().begin();

            Alumno alumno1 = new Alumno("Nico", "Clemente");
            Alumno alumno2 = new Alumno("Silvia", "Otaka");

            Curso curso1 = new Curso("Curso Java", "Andres");
            Curso curso2 = new Curso("Curso React", "Andres");

            alumno1.getCursos().add(curso1);
            alumno1.getCursos().add(curso2);
            alumno2.getCursos().add(curso1);

            em.persist(alumno1);
            em.persist(alumno2);

            em.getTransaction().commit();

            Alumno alumnoQuery1 = em.find(Alumno.class, alumno1.getId());
            Alumno alumnoQuery2 = em.find(Alumno.class, 2L);

            System.out.println(alumnoQuery1);
            System.out.println(alumnoQuery2);

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
