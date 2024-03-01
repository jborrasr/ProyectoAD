package org.example.view;

import org.example.controller.departamentosController;
import org.example.model.departamentos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertarDepartamento extends javax.swing.JDialog {
    private JPanel contentPane;
    private JButton btnInsertarDepartamento;
    private JTextField txt_NombreDepartamento;
    private JTextField txt_Ubicacion;
    private JButton btnVolver;

    public InsertarDepartamento(departamentosController controller) {
        setContentPane(contentPane);
        setModal(true);

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnInsertarDepartamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores de los campos de texto
                String nombreDepartamento = txt_NombreDepartamento.getText();
                String ubicacion = txt_Ubicacion.getText();

                // Crear un objeto departamentos con los valores ingresados
                departamentos departamento = new departamentos();
                departamento.setNombre(nombreDepartamento);
                departamento.setUbicacion(ubicacion);

                // Insertar el departamento utilizando el controlador
                departamentosController.insertarDepartamento(departamento);
            }
        });
    }


}
