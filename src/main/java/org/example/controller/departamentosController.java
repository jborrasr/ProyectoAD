package org.example.controller;

import org.example.model.departamentos;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.*;
import java.util.List;

public class departamentosController {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List<departamentos> obtenerDepartamentosDesdeBD() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM departamentos";
            Query<departamentos> query = session.createQuery(hql, departamentos.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo adecuado de excepciones en una aplicación real
        }
        return null;
    }



    public static void insertarDepartamento(departamentos departamento) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.save(departamento);
                transaction.commit();
                JOptionPane.showMessageDialog(null, "Departamento insertado correctamente");
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al insertar el departamento en la base de datos");
            }
        }
    }

    public void modificarDepartamento(departamentos departamento) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.update(departamento);
                transaction.commit();
                JOptionPane.showMessageDialog(null, "Departamento modificado correctamente");
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al modificar el Departamento en la base de datos");
            }
        }
    }

    public void eliminarDepartamento(departamentos idDepartamento) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                // Cargar la entidad desde la base de datos
                departamentos departamento = session.get(departamentos.class, idDepartamento.getId_Departamento());

                if (departamento != null) {
                    session.delete(departamento);
                    transaction.commit();
                    JOptionPane.showMessageDialog(null, "Departamento eliminado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un departamento con el ID proporcionado");
                }
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al eliminar el Departamento de la base de datos");
            }
        }
    }

}
