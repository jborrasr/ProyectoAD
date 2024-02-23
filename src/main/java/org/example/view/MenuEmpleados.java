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
    }
}
