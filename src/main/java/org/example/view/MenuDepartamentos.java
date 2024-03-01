package org.example.view;

import org.example.controller.departamentosController;

import javax.swing.*;

public class MenuDepartamentos extends JDialog {
    private JPanel contentPane;
    private JButton btnInsertarDepartamentos;
    private JButton btnModificarDepartamentos;
    private JButton btnEliminarDepartamentos;
    private JButton btnVolver;

    private departamentosController controller;

    public MenuDepartamentos() {
        this.controller = controller;
        setContentPane(contentPane);
        setModal(true);

        btnInsertarDepartamentos.addActionListener(e -> abrirMenuInsertar());
        btnModificarDepartamentos.addActionListener(e -> abrirMenuModificar());
        btnEliminarDepartamentos.addActionListener(e -> abrirMenuEliminar());
        btnVolver.addActionListener(e -> dispose());
    }

    private void abrirMenuInsertar() {
        InsertarDepartamento menuInsertar = new InsertarDepartamento(controller);
        menuInsertar.pack();
        menuInsertar.setLocationRelativeTo(null);
        menuInsertar.setVisible(true);
    }

    private void abrirMenuModificar() {
        ModificarDepartamento menuModificar = new ModificarDepartamento(controller);
        menuModificar.pack();
        menuModificar.setLocationRelativeTo(null);
        menuModificar.setVisible(true);
    }

    private void abrirMenuEliminar() {
        EliminarDepartamento menuEliminar = new EliminarDepartamento(controller);
        menuEliminar.pack();
        menuEliminar.setLocationRelativeTo(null);
        menuEliminar.setVisible(true);
    }
}
