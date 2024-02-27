package org.example.controller;

import org.example.model.empleados;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.swing.*;
import java.util.List;

public class empleadosController {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void insertarEmpleados(empleados empleado) {


        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                session.save(empleado);

                transaction.commit();

                JOptionPane.showMessageDialog(null, "Empleado insertado correctamente");
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al insertar el empleado en la base de datos");
            }
        }


    }

    public static void modificarEmpleados(empleados empleado) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.update(empleado);
                transaction.commit();
                JOptionPane.showMessageDialog(null, "Empleado modificado correctamente");
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al modificar el Empleado en la base de datos");
            }
        }
    }

    public static void eliminarCliente(empleados empleado) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.delete(empleado);
                transaction.commit();
                JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente");
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al eliminar el Empleado de la base de datos");
            }
        }
    }


    public List<empleados> obtenerEmpleadosdesdeBD() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM empleados ";
            Query<empleados> query = session.createQuery(hql, empleados.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }


}