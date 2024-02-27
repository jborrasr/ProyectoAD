package org.example.view;

import org.example.controller.empleadosController;
import org.example.model.departamentos;
import org.example.model.empleados;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertarEmpleados extends JDialog {
    private JPanel contentPane;
    private JButton btnInsertar;
    private JTextField txt_Nombre;
    private JTextField txt_Apellidos;
    private JTextField txt_DNI;
    private JTextField txt_Telefono;
    private JTextField txt_FechaNacimiento;
    private JTextField txt_FechaContratacion;
    private JTextField txt_Salario;
    private JTextField txt_Cargo;
    private JTextField txt_IdDepartamento;

    private empleadosController controller;

    public void InsertarEmpleado(empleados empleadoSeleccionado, boolean esInsertar) {
        this.controller = new empleadosController();
        setContentPane(contentPane);
        setModal(true);

        btnInsertar.addActionListener(this::actionPerformed);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInsertar) {
            empleados nuevoEmpleado = new empleados();
            nuevoEmpleado.setNombre(txt_Nombre.getText());
            nuevoEmpleado.setApellidos(txt_Apellidos.getText());
            nuevoEmpleado.setDni(txt_DNI.getText());
            nuevoEmpleado.setTelefono(txt_Telefono.getText());

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Ajusta el formato según tus necesidades

                Date fechaNacimiento = dateFormat.parse(txt_FechaNacimiento.getText());
                nuevoEmpleado.setFechaNacimiento(fechaNacimiento);

                Date fechaContratacion = dateFormat.parse(txt_FechaContratacion.getText());
                nuevoEmpleado.setFechaContratacion(fechaContratacion);

                double salario = Double.parseDouble(txt_Salario.getText());
                nuevoEmpleado.setSalario(salario);
            } catch (NumberFormatException | ParseException ex) {
                JOptionPane.showMessageDialog(null, "Formato de número o fecha inválido");
                return;
            }


            nuevoEmpleado.setCargo(txt_Cargo.getText());

            // Validaciones adicionales si es necesario...

            // Llamar al método del controlador para insertar el empleado
            controller.insertarEmpleados(nuevoEmpleado);
        }
    }



    private void insertarEmpleado(String nombre, String apellidos, String dni, String telefono,
                                  Date fechaNacimiento, Date fechaContratacion, double salario,
                                  String cargo, departamentos id_departamento) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            empleados empleado = new empleados();
            empleado.setNombre(nombre);
            empleado.setApellidos(apellidos);
            empleado.setDni(dni);
            empleado.setTelefono(telefono);
            empleado.setFechaNacimiento(fechaNacimiento);
            empleado.setFechaContratacion(fechaContratacion);
            empleado.setSalario(salario);
            empleado.setCargo(cargo);
            empleado.setId_departamento(id_departamento);

            session.save(empleado);

            transaction.commit();
            System.out.println("Empleado insertado con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
