package org.example.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.model.empleados;
import org.example.model.registros;

import java.util.List;

public class registrosController {
    private static final String PERSISTENCE_UNIT_NAME = "hibernate-clase-jpa";
    private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static empleados obtenerEmpleadoPorTelefono(String telefono) {
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // Realiza una consulta para obtener el empleado por el telefono
            List<empleados> resultList = entityManager
                    .createQuery("SELECT e FROM empleados e WHERE e.telefono = :telefono", empleados.class)
                    .setParameter("telefono", telefono)
                    .getResultList();

            if (!resultList.isEmpty()) {
                // Devuelve el primer empleado encontrado (puedes ajustar esto según tus necesidades)
                return resultList.get(0);
            }
        } finally {
            entityManager.getTransaction().commit();
            entityManager.close();
        }

        return null;
    }

    public static void guardarRegistro(registros nuevoRegistro) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Guarda el nuevo registro en la base de datos
            entityManager.persist(nuevoRegistro);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
            throw new RuntimeException("Error al guardar el registro en la base de datos: " + ex.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public List<String> obtenerListaTelefonos() {
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // Realiza una consulta para obtener la lista de telefonos
            List<String> listaTelefonos = entityManager
                    .createQuery("SELECT e.telefono FROM empleados e", String.class)
                    .getResultList();

            return listaTelefonos;
        } finally {
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }

    public void insertarDescanso(String selectedTelefono) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Obtener el empleado por teléfono
            empleados empleado = obtenerEmpleadoPorTelefono(selectedTelefono);

            if (empleado != null) {
                // Crear una nueva instancia de la entidad registros
                registros nuevoDescanso = new registros();
                nuevoDescanso.setFecha_Entrada(new java.util.Date());
                nuevoDescanso.setFecha_Salida(null);
                nuevoDescanso.setTelefono(empleado);

                // Guardar el nuevo descanso en la base de datos
                entityManager.persist(nuevoDescanso);

                transaction.commit();
            } else {
                throw new RuntimeException("Empleado no encontrado");
            }
        } catch (Exception ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
            throw new RuntimeException("Error al insertar el descanso en la base de datos: " + ex.getMessage());
        } finally {
            entityManager.close();
        }
    }
}
