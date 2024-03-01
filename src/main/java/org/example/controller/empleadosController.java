package org.example.controller;

import org.example.model.departamentos;
import org.example.model.empleados;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class empleadosController {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();



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

    public static void eliminarEmpleadoPorId(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                empleados empleado = session.get(empleados.class, id);

                if (empleado != null) {
                    session.delete(empleado); // Utilizando delete para eliminar el empleado
                    transaction.commit();
                    JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un empleado con el ID proporcionado");
                }
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al eliminar el Empleado de la base de datos");
            }
        }
    }





    public List<departamentos> obtenerDepartamentosdesdeBD() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM departamentos";
            Query<departamentos> query = session.createQuery(hql, departamentos.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<empleados> obtenerEmpleados() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM empleados";
            Query<empleados> query = session.createQuery(hql, empleados.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Integer> obtenerIDDepartamentos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT id_Departamento FROM departamentos";
            Query<Integer> query = session.createQuery(hql, Integer.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static empleados obtenerEmpleadoPorId(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(empleados.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> obtenerNombreEmpleados(){
        try( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            return session.createQuery("select nombre from empleados ", String.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<empleados> getEmpleados() {
        try( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            return session.createQuery("from empleados ", empleados.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<empleados> obtenerEmpleadosDesdeBD() {
        List<empleados> listaEmpleados = new ArrayList<>();

        // Abrir una sesión de Hibernate
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Iniciar una transacción
            Transaction transaction = session.beginTransaction();

            // Consulta para obtener todos los empleados
            String hql = "FROM empleados";
            Query<empleados> query = session.createQuery(hql, empleados.class);
            listaEmpleados = query.list();

            // Commit de la transacción
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades (puedes lanzarla nuevamente, loguearla, mostrar un mensaje, etc.)
        }

        return listaEmpleados;
    }


    public List<String> obtenerListaDni() {
        List<String> listaDni = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT dni FROM empleados"; // Reemplaza TuEntidadDni con el nombre de tu entidad
            Query<String> query = session.createQuery(hql, String.class);
            listaDni = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de errores: puedes lanzar una excepción personalizada o mostrar un mensaje
        }
        return listaDni;
    }

}