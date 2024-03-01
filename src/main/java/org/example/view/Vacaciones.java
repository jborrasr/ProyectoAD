package org.example.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.example.controller.empleadosController;
import org.example.controller.vacacionesController;
import org.example.model.departamentos;
import org.example.model.empleados;
import org.example.model.vacaciones;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Vacaciones extends JDialog {
    private JPanel contentPane;
    private JTextField txt_Diadevacaciones;
    private JButton btnInsertarVacaciones;
    private JComboBox<String> cboxDni;
    private JComboBox<Long> cboxIdDepartamento;
    private JButton btnVolver;

    empleadosController controller = new empleadosController();
    private SessionFactory sessionFactory;

    public Vacaciones() {
        sessionFactory = HibernateUtil.getSessionFactory();
        setContentPane(contentPane);
        setModal(true);

        this.sessionFactory = sessionFactory;

        cargarDnis();
        cargarId();

        btnInsertarVacaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarVacaciones();
            }
        });

        btnInsertarVacaciones.addActionListener(e -> insertarVacaciones());
        btnVolver.addActionListener(e -> dispose());
    }

    private void cargarDnis() {
        List<String> listaDni = controller.obtenerListaDni();

        cboxDni.removeAllItems();

        for (String dni : listaDni) {
            cboxDni.addItem(dni);
        }
    }

    private void cargarId() {
        try (Session session = sessionFactory.openSession()) {
            List<Long> listaId = session.createQuery("SELECT id_Departamento FROM departamentos ").list();

            cboxIdDepartamento.removeAllItems();

            for (Long id : listaId) {
                cboxIdDepartamento.addItem(id);
            }
        }
    }

    private void insertarVacaciones() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            String dniSeleccionado = (String) cboxDni.getSelectedItem();
            Long idDepartamentoSeleccionado = (Long) cboxIdDepartamento.getSelectedItem();
            String fechaVacaciones = txt_Diadevacaciones.getText();

            // Convertir el String a Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date diaVacaciones;

            try {
                diaVacaciones = new java.sql.Date(dateFormat.parse(fechaVacaciones).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Utiliza el formato dd/MM/yyyy.");
                return;  // Salir del método si hay un error en la conversión de fecha
            }

            // Crear una nueva instancia de la entidad vacaciones
            vacaciones nuevaVacacion = new vacaciones();
            nuevaVacacion.setDni(obtenerEmpleadoPorDni(dniSeleccionado, session));
            nuevaVacacion.setId_departamento(obtenerNombreDepartamentoPorId(idDepartamentoSeleccionado, session));
            nuevaVacacion.setDia_Vacaciones(diaVacaciones);

            // Llamar al método insertarVacaciones del controlador
            new vacacionesController().insertarVacaciones(nuevaVacacion);

            transaction.commit();
            // Eliminar la siguiente línea que imprime el mensaje de éxito
            // JOptionPane.showMessageDialog(this, "Vacaciones insertadas correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al insertar vacaciones");
        }

        // Mostrar el mensaje de éxito aquí, después de haber completado la operación correctamente
        JOptionPane.showMessageDialog(this, "Vacaciones insertadas correctamente");
    }


    private departamentos obtenerNombreDepartamentoPorId(Long idDepartamentoSeleccionado, Session session) {
        try {
            return session.get(departamentos.class, idDepartamentoSeleccionado);
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo adecuado de excepciones en una aplicación real
        }
        return null;
    }

    private empleados obtenerEmpleadoPorDni(String dniSeleccionado, Session session) {
        try {
            String hql = "FROM empleados WHERE dni = :dni";
            Query<empleados> query = session.createQuery(hql, empleados.class);
            query.setParameter("dni", dniSeleccionado);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo adecuado de excepciones en una aplicación real
        }
        return null;
    }

}
