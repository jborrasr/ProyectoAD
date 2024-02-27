package org.example.view;

import javax.swing.*;

public class Vacaciones extends JDialog {
    private JPanel contentPane;
    private JTextField txt_Diadevacaciones;
    private JButton btnInsertarVacaciones;
    private JButton btnCancelar;
    private JComboBox cboxDni;
    private JComboBox cboxIdDepartamento;

    public Vacaciones() {
        setContentPane(contentPane);
        setModal(true);
    }
}
