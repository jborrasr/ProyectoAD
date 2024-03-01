package org.example.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.model.vacaciones;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.sql.Date;
import java.util.List;

public class vacacionesController {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-clase-jpa");

    public static void insertarVacaciones(vacaciones vacaciones) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Convertir java.util.Date a java.sql.Date antes de guardar en la base de datos
            Date fechaInicio = new Date(vacaciones.getDia_Vacaciones().getTime());

            vacaciones.setDia_Vacaciones(fechaInicio);

            // Guardar las nuevas vacaciones en la base de datos
            entityManager.persist(vacaciones);

            transaction.commit();
            JOptionPane.showMessageDialog(null, "Vacaciones insertadas correctamente");
        } catch (Exception ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al insertar las vacaciones en la base de datos: " + ex.getMessage());
        } finally {
            entityManager.close();
        }

    }

    public String obtenerNombreDepartamentoPorId(Long idDepartamento) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // Realiza una consulta para obtener el nombre del departamento por el ID
            String nombreDepartamento = (String) entityManager
                    .createQuery("SELECT nombreDespartamento FROM departamentos d WHERE d.id_Departamento = :idDepartamento")
                    .setParameter("idDepartamento", idDepartamento)
                    .getSingleResult();

            return nombreDepartamento;
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo adecuado de excepciones en una aplicación real
        } finally {
            entityManager.close();
        }

        return null;
    }

    public List<String> obtenerListaDni() {
        List<String> listaDni = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            listaDni = session.createQuery("SELECT dni FROM empleados").list();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return listaDni;
    }
}
