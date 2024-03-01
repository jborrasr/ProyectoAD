package org.example.view;

import org.example.controller.departamentosController;
import org.example.model.departamentos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class EliminarDepartamento extends javax.swing.JDialog {
    private JPanel contentPane;
    private JButton btnVolver;
    private JComboBox cboxEliminarDepartamento;
    private JButton btnEliminarDepartamento;

    private departamentosController controller;

    public EliminarDepartamento(departamentosController controller) {
        super();
        this.controller = new departamentosController();// Asigna el controlador
         // Carga los departamentos al iniciar la ventana
        setContentPane(contentPane);
        setModal(true);
        cargarDepartamentos();
        btnEliminarDepartamento.addActionListener(this::eliminarDepartamento);
        btnVolver.addActionListener(e -> dispose());
    }




    private void cargarDepartamentos() {
        if (this.controller != null) {

            List<departamentos> listaDepartamentos = this.controller.obtenerDepartamentosDesdeBD();

            if (listaDepartamentos != null) {

                cboxEliminarDepartamento.removeAllItems();


                for (departamentos departamento : listaDepartamentos) {
                    cboxEliminarDepartamento.addItem(departamento.getNombre());
                }
            } else {
                System.err.println("Error: La lista de departamentos es nula.");

            }
        } else {
            System.err.println("Error: El controlador es nulo al cargar departamentos.");

        }
    }

    private void eliminarDepartamento(ActionEvent e) {
        String departamentoSeleccionado = (String) cboxEliminarDepartamento.getSelectedItem();

        if (departamentoSeleccionado != null) {

            if (DialogUtils.mostrarConfirmacion("¿Estás seguro de que deseas eliminar el departamento?", "Confirmar Eliminación")) {
                for(var departamento : controller.obtenerDepartamentosDesdeBD())
                {
                    if(departamento.getNombre() == departamentoSeleccionado)
                    {

                        controller.eliminarDepartamento(departamento);
                        cargarDepartamentos();
                    }
                }

            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un departamento para eliminar.");
        }
    }




}
