package org.example.view;

import javax.swing.*;

public class InsertarDepartamento extends javax.swing.JDialog {
private javax.swing.JPanel contentPane;
    private JButton btnInsertarDepartamento;
    private JTextField txt_NombreDepartamento;
    private JTextField txt_Ubicacion;
    private JButton btnVolver;

    public InsertarDepartamento() {
        setContentPane(contentPane);
        setModal(true);

        btnVolver.addActionListener(e -> dispose());
    }
}
