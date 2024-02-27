package org.example.view;

import javax.swing.*;
import java.awt.event.*;

public class MenuRegistro extends JDialog {
    private JPanel contentPane;

    private JButton btnRegistroEntradaSalida;
    private JButton btnDescansos;
    private JButton btnHorasTrabajadas;
    private JButton btnVolver;



    public MenuRegistro() {
        setContentPane(contentPane);
        setModal(true);
        btnRegistroEntradaSalida.addActionListener(e -> abrirmenuEntradaSalida());
        btnHorasTrabajadas.addActionListener(e -> abrirMenuHorasTrabajadas());
        btnDescansos.addActionListener(e -> abrirMenuDescansos());
        btnVolver.addActionListener(e -> dispose());



    }

    private void abrirmenuEntradaSalida() {
        Registros menuRegistros = new Registros();
        menuRegistros.pack();
        menuRegistros.setLocationRelativeTo(null);
        menuRegistros.setVisible(true);
    }

    private void abrirMenuHorasTrabajadas() {
        HorasTrabajadas menuHoras = new HorasTrabajadas();
        menuHoras.pack();
        menuHoras.setLocationRelativeTo(null);
        menuHoras.setVisible(true);
    }
    private void abrirMenuDescansos() {
        Descansos menuDescansos = new Descansos();
        menuDescansos.pack();
        menuDescansos.setLocationRelativeTo(null);
        menuDescansos.setVisible(true);
    }



}
