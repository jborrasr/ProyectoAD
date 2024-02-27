package org.example.view;

import javax.swing.*;

public class HorasTrabajadas extends JDialog {
    private JPanel contentPane;
    private JButton btnVolver;
    private JComboBox cboxEmpleado;
    private JButton btnBuscar;
    private JTextArea txtArea_HorasTrabajadas;

    public HorasTrabajadas() {
        setContentPane(contentPane);
        setModal(true);
    }
}
