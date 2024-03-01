package org.example.view;

import org.example.controller.empleadosController;
import org.example.model.departamentos;
import org.example.model.empleados;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EliminarEmpleado extends JDialog{
    private JPanel contentPane;
    private JButton btnVolver;
    private JComboBox cboxEliminarEmpleado;
    private JButton btnEliminarEmpleado;

    private empleadosController controller;

    public EliminarEmpleado() {
        super();
        this.controller = new empleadosController();


        setContentPane(contentPane);
        setModal(true);


        cargarDepartamentos();

        btnEliminarEmpleado.addActionListener(e -> eliminarEmpleado());
        btnVolver.addActionListener(e -> dispose());


    }


    private void cargarDepartamentos() {
        List<String> listaempleados = empleadosController.obtenerNombreEmpleados();

        // Limpiar JComboBox antes de cargar nuevos elementos
        cboxEliminarEmpleado.removeAllItems();

        // Agregar departamentos al JComboBox
        for (String empleados : listaempleados) {
            cboxEliminarEmpleado.addItem(empleados);
        }
    }


    private void eliminarEmpleado() {
        String seleccion = (String) cboxEliminarEmpleado.getSelectedItem();

        if (seleccion != null) {
            Long idEmpleado = obtenerIdEmpleadoDesdeNombre(seleccion);
            if (idEmpleado != null) {

                controller.eliminarEmpleadoPorId(idEmpleado);
                cargarDepartamentos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al obtener el ID del empleado seleccionado");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún empleado.");
        }
    }

    private Long obtenerIdEmpleadoDesdeNombre(String nombreCompleto) {
        List<empleados> listaEmpleados = empleadosController.getEmpleados();
        for (empleados empleado : listaEmpleados) {
            if (empleado.getNombre().equals(nombreCompleto)) {
                return empleado.getNif();
            }
        }
        return null;
    }
}
