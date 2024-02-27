package org.example.view;

import javax.swing.*;

public class MenuEmpleados extends JDialog {
    private JPanel contentPane;
    private JButton btnInsertarEmpleado;
    private JButton btnEliminarEmpleado;
    private JButton btnModificarEmpleado;
    private JButton btnVolver;

    public MenuEmpleados() {
        setContentPane(contentPane);
        setModal(true);

        btnInsertarEmpleado.addActionListener(e -> abrirMenuInsertar());
        btnModificarEmpleado.addActionListener(e -> abrirMenuModificar());
        btnEliminarEmpleado.addActionListener(e -> abrirMenuEliminar());
        btnVolver.addActionListener(e -> dispose());

    }

    private void abrirMenuInsertar() {
        InsertarEmpleados menuInsertar = new InsertarEmpleados();
        menuInsertar.pack();
        menuInsertar.setLocationRelativeTo(null);
        menuInsertar.setVisible(true);
    }

    private void abrirMenuModificar() {
        ModificarEmpleados menuModificar = new ModificarEmpleados();
        menuModificar.pack();
        menuModificar.setLocationRelativeTo(null);
        menuModificar.setVisible(true);
    }
    private void abrirMenuEliminar() {
        EliminarEmpleado menuEliminar = new EliminarEmpleado();
        menuEliminar.pack();
        menuEliminar.setLocationRelativeTo(null);
        menuEliminar.setVisible(true);
    }
}
