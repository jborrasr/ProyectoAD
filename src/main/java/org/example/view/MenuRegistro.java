package org.example.view;

import javax.swing.*;
import java.awt.event.*;

public class MenuRegistro extends JDialog {
    private JPanel contentPane;
    private JButton btnInsertarRegistro;
    private JButton btnModificarRegistro;
    private JButton btnEliminarRegistro;
    private JButton btnVolver;

    public MenuRegistro() {
        setContentPane(contentPane);
        setModal(true);
    }

}
