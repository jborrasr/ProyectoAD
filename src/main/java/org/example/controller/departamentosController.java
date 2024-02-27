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

    public static void modificarDepartamento(departamentos departamento) {
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

    public static void eliminarDepartamento(departamentos departamento) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.delete(departamento);
                transaction.commit();
                JOptionPane.showMessageDialog(null, "Departamento eliminado correctamente");
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al eliminar el Departamento de la base de datos");
            }
        }
    }


    public List<departamentos> obtenerDepartamentosdesdeBD() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM departamentos ";
            Query<departamentos> query = session.createQuery(hql, departamentos.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

}
