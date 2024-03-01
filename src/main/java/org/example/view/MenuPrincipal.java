package org.example.view;

import org.example.controller.empleadosController;
import org.example.util.HibernateUtil;

import javax.swing.*;
import java.awt.*;
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

        btnMenuEmpleados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMenuEmpleados();
            }
        });

        btnMenuDepartamentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMenuDepartamentos();
            }
        });

        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMenuRegistro();
            }
        });

        btnVacaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMenuVacaciones();
            }
        });
    }


    private void abrirMenuEmpleados() {
        empleadosController controller = new empleadosController();
        MenuEmpleados menuEmpleados = new MenuEmpleados(controller);
        menuEmpleados.pack();
        menuEmpleados.setLocationRelativeTo(null);
        menuEmpleados.setVisible(true);
    }
    private void abrirMenuDepartamentos() {
        MenuDepartamentos menuDepartamentos = new MenuDepartamentos();
        menuDepartamentos.pack();
        menuDepartamentos.setLocationRelativeTo(null);
        menuDepartamentos.setVisible(true);
    }

    private void abrirMenuRegistro() {
        MenuRegistro menuRegistros = new MenuRegistro();
        menuRegistros.pack();
        menuRegistros.setLocationRelativeTo(null);
        menuRegistros.setVisible(true);
    }

    private void abrirMenuVacaciones() {
        Vacaciones menuVacaciones = new Vacaciones();
        menuVacaciones.pack();
        menuVacaciones.setLocationRelativeTo(null);
        menuVacaciones.setVisible(true);
    }


}
