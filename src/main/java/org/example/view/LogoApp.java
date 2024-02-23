package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoApp {
    private JPanel contentPane;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Logo App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true); // Quita la barra de título del JFrame
        frame.setBackground(new Color(0, 0, 0, 0));
        // Agrega un JPanel con el logo de la empresa

        ImageIcon logoIcon = new ImageIcon("src/main/resources/assets/master-yi-dance.gif"); // Reemplaza con la ruta real de tu logo
        JLabel logoLabel = new JLabel(logoIcon);
        frame.add(logoLabel);



        // Muestra el JFrame
        frame.setVisible(true);

        // Espera 3 segundos antes de cerrar la aplicación
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cierra la aplicación después de 3 segundos
                abrirMenuPrincipal();
            }
        });
        timer.setRepeats(false); // Solo se ejecuta una vez
        timer.start();
    }

    private static void abrirMenuPrincipal() {
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.pack();
        menuPrincipal.setLocationRelativeTo(null);
        menuPrincipal.setVisible(true);

    }
}
