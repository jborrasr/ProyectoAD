package org.example.view;


import javax.swing.JOptionPane;

public class DialogUtils {

    public static boolean mostrarConfirmacion(String mensaje, String titulo) {
        int confirmacion = JOptionPane.showConfirmDialog(
                null,
                mensaje,
                titulo,
                JOptionPane.YES_NO_OPTION
        );
        return confirmacion == JOptionPane.YES_OPTION;
    }
}
