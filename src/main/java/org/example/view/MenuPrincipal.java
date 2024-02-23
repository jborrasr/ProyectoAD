package org.example.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {
    private JPanel contentPane;
    private JButton btnMenuEmpleados;
    private JButton btnMenuDepartamentos;
    private JButton btnRegistro;
    private JButton btnVacaciones;

    public MenuPrincipal() {
        setContentPane(contentPane);

        // Agrega un ActionListener al botón btnMenuEmpleados
        btnMenuEmpleados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMenuEmpleados();
            }
        });
    }


    private void abrirMenuEmpleados() {
        MenuEmpleados menuEmpleados = new MenuEmpleados();
        menuEmpleados.pack();
        menuEmpleados.setLocationRelativeTo(null);
        menuEmpleados.setVisible(true);
    }


}
