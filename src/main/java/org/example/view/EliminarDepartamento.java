package org.example.view;

import javax.swing.*;

public class EliminarDepartamento extends javax.swing.JDialog {
private javax.swing.JPanel contentPane;
    private JButton btnVolver;
    private JComboBox cboxEliminarDepartamento;
    private JButton btnEliminarDepartamento;

    public EliminarDepartamento() {
        setContentPane(contentPane);
        setModal(true);

        btnVolver.addActionListener(e -> dispose());
    }
}
