package org.example.view;

import org.example.controller.vacacionesController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Descansos extends JDialog {
    private JPanel contentPane;
    private JButton btnVolver;
    private JComboBox<String> cbox_dni;
    private JButton btnDescanso;

    private final vacacionesController controller = new vacacionesController();

    public Descansos() {
        setContentPane(contentPane);
        setModal(true);

        cargarDnis();

        btnDescanso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnVolver.addActionListener(e -> dispose());
    }

    private void cargarDnis() {
        List<String> listaDni = controller.obtenerListaDni();

        cbox_dni.removeAllItems();

        for (String dni : listaDni) {
            cbox_dni.addItem(dni);
        }
    }

    
}
