package org.example.view;

import javax.swing.*;

public class MenuDepartamentos extends JDialog {
    private JPanel contentPane;
    private JButton btnInsertarDepartamentos;
    private JButton btnModificarDepartamentos;
    private JButton btnEliminarDepartamentos;
    private JButton btnVolver;



public MenuDepartamentos() {
        setContentPane(contentPane);
        setModal(true);

    btnInsertarDepartamentos.addActionListener(e -> abrirMenuInsertar());
    btnModificarDepartamentos.addActionListener(e -> abrirMenuModificar());
    btnEliminarDepartamentos.addActionListener(e -> abrirMenuEliminar());
    btnVolver.addActionListener(e -> dispose());
    }

    private void abrirMenuInsertar() {
        InsertarDepartamento menuInsertar = new InsertarDepartamento();
        menuInsertar.pack();
        menuInsertar.setLocationRelativeTo(null);
        menuInsertar.setVisible(true);
    }

    private void abrirMenuModificar() {
        ModificarDepartamento menuModificar = new ModificarDepartamento();
        menuModificar.pack();
        menuModificar.setLocationRelativeTo(null);
        menuModificar.setVisible(true);
    }
    private void abrirMenuEliminar() {
        EliminarDepartamento menuEliminar = new EliminarDepartamento();
        menuEliminar.pack();
        menuEliminar.setLocationRelativeTo(null);
        menuEliminar.setVisible(true);
    }
}
