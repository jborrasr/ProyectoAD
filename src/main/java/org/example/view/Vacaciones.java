package org.example.view;

import javax.swing.*;

public class Vacaciones extends JDialog {
    private JPanel contentPane;
    private JTextField txt_Diadevacaciones;
    private JButton btnInsertarVacaciones;
    private JComboBox cboxDni;
    private JComboBox cboxIdDepartamento;
    private JButton btnVolver;

    public Vacaciones() {
        setContentPane(contentPane);
        setModal(true);

        btnVolver.addActionListener(e -> dispose());
    }
}
