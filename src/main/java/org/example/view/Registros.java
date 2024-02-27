package org.example.view;

import javax.swing.*;

public class Registros extends JDialog {
    private JPanel contentPane;
    private JTextField txt_FechaEntrada;
    private JTextField txt_FechaSalida;
    private JButton btnFichar;
    private JComboBox cboxDni;
    private JButton btnVolver;

    public Registros() {
        setContentPane(contentPane);
        setModal(true);

        btnVolver.addActionListener(e -> dispose());
    }
}
