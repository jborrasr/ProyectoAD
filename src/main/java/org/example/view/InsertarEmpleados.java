package org.example.view;

import org.example.controller.empleadosController;
import org.example.model.departamentos;
import org.example.model.empleados;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class InsertarEmpleados extends JDialog {
    private JPanel contentPane;
    private JButton btnInsertarEmpleado;
    private JTextField txt_Nombre;
    private JTextField txt_Apellidos;
    private JTextField txt_Dni;
    private JTextField txt_Telefono;
    private JTextField txt_FechaNacimiento;
    private JTextField txt_FechaContratacion;
    private JTextField txt_Salario;
    private JTextField txt_Cargo;
    private JComboBox cbox_IdDepartamento;

    private JButton btnVolver;


    private empleadosController controller;

    public InsertarEmpleados(empleados empleadoSeleccionado, boolean esInsertar) {
        this.controller = new empleadosController();
        setContentPane(contentPane);
        setModal(true);

        // Obtener y cargar departamentos en el JComboBox
        cargarDepartamentos();

        btnInsertarEmpleado.addActionListener(this::actionPerformed);
    }

    public InsertarEmpleados() {
        // Llama al constructor predeterminado de la clase base
        super();

        this.controller = new empleadosController();
        setContentPane(contentPane);
        setModal(true);

        // Obtener y cargar departamentos en el JComboBox
        cargarDepartamentos();

        btnInsertarEmpleado.addActionListener(this::actionPerformed);
        btnVolver.addActionListener(e -> dispose());
    }

    private void cargarDepartamentos() {
        List<departamentos> listaDepartamentos = controller.obtenerDepartamentosdesdeBD();

        // Limpiar JComboBox antes de cargar nuevos elementos
        cbox_IdDepartamento.removeAllItems();

        // Agregar departamentos al JComboBox
        for (departamentos departamento : listaDepartamentos) {
            cbox_IdDepartamento.addItem(departamento);
        }
    }

    public void actionPerformed(ActionEvent e) {
        empleados nuevoEmpleado;

        if (e.getSource() == btnInsertarEmpleado) {
            // Verificar campos vacíos
            if (camposVacios()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios. Completa todos los campos.");
                return;
            }

            nuevoEmpleado = new empleados();

            nuevoEmpleado.setNombre(txt_Nombre.getText());
            nuevoEmpleado.setApellidos(txt_Apellidos.getText());
            nuevoEmpleado.setDni(txt_Dni.getText());
            nuevoEmpleado.setTelefono(txt_Telefono.getText());

            String fechaContratacionStr = txt_FechaContratacion.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            try {
                LocalDate fechaContratacion = LocalDate.parse(fechaContratacionStr, formatter);
                nuevoEmpleado.setFechaContratacion(fechaContratacion);
            } catch (DateTimeParseException ex) {
                // Mostrar mensaje de error y salir del método
                JOptionPane.showMessageDialog(this, "Error en el formato de fecha de contratación. Utiliza el formato dd/MM/yyyy");
                return;
            }

            String fechaNacimientoStr = txt_FechaNacimiento.getText();

            try {
                LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
                nuevoEmpleado.setFechaNacimiento(fechaNacimiento);
            } catch (DateTimeParseException ex) {
                // Mostrar mensaje de error y salir del método
                JOptionPane.showMessageDialog(this, "Error en el formato de fecha de nacimiento. Utiliza el formato dd/MM/yyyy");
                return;
            }

            nuevoEmpleado.setSalario(Double.parseDouble(txt_Salario.getText()));
            nuevoEmpleado.setCargo(txt_Cargo.getText());

            // Obtener el departamento seleccionado del JComboBox
            departamentos departamentoSeleccionado = (departamentos) cbox_IdDepartamento.getSelectedItem();

            if (departamentoSeleccionado != null) {
                nuevoEmpleado.setId_departamento(departamentoSeleccionado);
            } else {
                // Manejar el caso en el que el elemento seleccionado no sea una instancia de departamentos
                JOptionPane.showMessageDialog(this, "Error al obtener el departamento seleccionado");
                return;
            }

            // Llamar al método del controlador para insertar el empleado
            controller.insertarEmpleados(nuevoEmpleado);
        }
    }

    private boolean camposVacios() {
        // Verificar si algún campo está vacío
        return txt_Nombre.getText().isEmpty() ||
                txt_Apellidos.getText().isEmpty() ||
                txt_Dni.getText().isEmpty() ||
                txt_Telefono.getText().isEmpty() ||
                txt_FechaContratacion.getText().isEmpty() ||
                txt_FechaNacimiento.getText().isEmpty() ||
                txt_Salario.getText().isEmpty() ||
                txt_Cargo.getText().isEmpty() ||
                cbox_IdDepartamento.getSelectedItem() == null;
    }

}



