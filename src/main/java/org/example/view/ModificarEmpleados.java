package org.example.view;

import org.example.controller.empleadosController;
import org.example.model.departamentos;
import org.example.model.empleados;
import org.example.util.HibernateUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class ModificarEmpleados extends javax.swing.JDialog {
    private javax.swing.JPanel contentPane;
    private JTextField txt_Nombre;
    private JTextField txt_Apellidos;
    private JTextField txt_Dni;
    private JTextField txt_Telefono;
    private JTextField txt_FechaNacimiento;
    private JTextField txt_FechaContratacion;
    private JTextField txt_Salario;
    private JTextField txt_Cargo;
    private JComboBox cbox_IdDepartamento;
    private JButton btnModificarEmpleado;
    private JButton btnVolver;

    private empleadosController controller;
    private empleados empleadoSeleccionado;





    // Constructor para la inserción y modificación de empleados
    public ModificarEmpleados(empleadosController controller, empleados empleadoSeleccionado) {
        this.controller = controller;
        this.empleadoSeleccionado = empleadoSeleccionado;

        setContentPane(contentPane);
        setModal(true);

        // Obtener y cargar departamentos en el JComboBox
        cargarDepartamentos();

        // Rellenar los campos con la información del empleado seleccionado
        txt_Nombre.setText(empleadoSeleccionado.getNombre());
        txt_Apellidos.setText(empleadoSeleccionado.getApellidos());
        txt_Dni.setText(empleadoSeleccionado.getDni());
        txt_Telefono.setText(empleadoSeleccionado.getTelefono());
        txt_FechaContratacion.setText(empleadoSeleccionado.getFechaContratacion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        txt_FechaNacimiento.setText(empleadoSeleccionado.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        txt_Salario.setText(String.valueOf(empleadoSeleccionado.getSalario()));
        txt_Cargo.setText(empleadoSeleccionado.getCargo());
        cbox_IdDepartamento.setSelectedItem(empleadoSeleccionado.getId_departamento());

        // Asocia los eventos de los botones a los métodos correspondientes
        btnModificarEmpleado.addActionListener(this::actionPerformed);
        btnVolver.addActionListener(e -> dispose());
    }



    public ModificarEmpleados(empleadosController controller) {
        this.controller = controller;

        setContentPane(contentPane);
        setModal(true);

        cargarDepartamentos();



        btnModificarEmpleado.addActionListener(this::actionPerformed);
        btnVolver.addActionListener(e -> dispose());
    }

    private void deshabilitarCamposYBoton() {
        txt_Nombre.setEnabled(false);
        // Deshabilita los demás campos

        btnModificarEmpleado.setEnabled(false);
    }

    private void habilitarCamposYBoton() {
        txt_Nombre.setEnabled(true);
        // Habilita los demás campos

        btnModificarEmpleado.setEnabled(true);
    }

    public void seleccionarEmpleado(ActionEvent e) {
        empleados empleadoSeleccionado = obtenerEmpleadoSeleccionado();

        if (empleadoSeleccionado != null) {
            // Llenar los campos con la información del empleado seleccionado
            llenarCampos(empleadoSeleccionado);

            // Almacenar el empleado seleccionado para su posterior modificación
            this.empleadoSeleccionado = empleadoSeleccionado;

            // Habilita los campos y el botón de modificación
            habilitarCamposYBoton();
        }
    }

    private void llenarCampos(empleados empleado) {
        txt_Nombre.setText(empleado.getNombre());
        // Llena los demás campos
    }


    static empleados obtenerEmpleadoSeleccionado() {
        empleadosController controller = new empleadosController();

        // Obtener la lista de empleados desde la base de datos o donde sea que los tengas almacenados
        List<empleados> listaEmpleados = controller.obtenerEmpleadosDesdeBD();

        // Crear un arreglo de Strings para mostrar en el diálogo de selección
        String[] opciones = new String[listaEmpleados.size()];
        for (int i = 0; i < listaEmpleados.size(); i++) {
            opciones[i] = listaEmpleados.get(i).getNombreCompleto();
        }

        // Mostrar un diálogo de selección
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona un empleado:",
                "Selección de Empleado",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones.length > 0 ? opciones[0] : null
        );

        // Obtener el empleado seleccionado y retornarlo
        if (seleccion != null) {
            for (empleados empleado : listaEmpleados) {
                if (empleado.getNombreCompleto().equals(seleccion)) {
                    return empleado;
                }
            }
        }

        return null;  // Si no se selecciona ningún empleado
    }




    private void mostrarVentanaModificarEmpleados() {
        ModificarEmpleados modificarEmpleados = new ModificarEmpleados(controller, empleadoSeleccionado);
        modificarEmpleados.setVisible(true);
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

    private void llenarCampos() {
        txt_Nombre.setText(empleadoSeleccionado.getNombre());
        txt_Apellidos.setText(empleadoSeleccionado.getApellidos());
        txt_Dni.setText(empleadoSeleccionado.getDni());
        txt_Telefono.setText(empleadoSeleccionado.getTelefono());
        txt_FechaContratacion.setText(empleadoSeleccionado.getFechaContratacion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        txt_FechaNacimiento.setText(empleadoSeleccionado.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        txt_Salario.setText(String.valueOf(empleadoSeleccionado.getSalario()));
        txt_Cargo.setText(empleadoSeleccionado.getCargo());
        cbox_IdDepartamento.setSelectedItem(empleadoSeleccionado.getId_departamento());
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

    public void actionPerformed(ActionEvent e) {
        empleados nuevoEmpleado;

        // Verificar campos vacíos
        if (camposVacios()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios. Completa todos los campos.");
            return;
        }

        // Si estamos modificando un empleado, utilizamos el objeto existente
        if (empleadoSeleccionado != null) {
            nuevoEmpleado = empleadoSeleccionado;
        } else {
            nuevoEmpleado = new empleados();
        }

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
            JOptionPane.showMessageDialog(this, "Error en el formato de fecha de contratación. Utiliza el formato dd/MM/yyyy");
            return;
        }

        String fechaNacimientoStr = txt_FechaNacimiento.getText();

        try {
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
            nuevoEmpleado.setFechaNacimiento(fechaNacimiento);
        } catch (DateTimeParseException ex) {
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
            JOptionPane.showMessageDialog(this, "Error al obtener el departamento seleccionado");
            return;
        }

        // Llamar al método del controlador para insertar o modificar el empleado
        if (empleadoSeleccionado == null) {
            controller.insertarEmpleados(nuevoEmpleado);
        } else {
            controller.modificarEmpleados(nuevoEmpleado);
        }

        // Cerrar la ventana después de insertar o modificar
        dispose();
    }


}

