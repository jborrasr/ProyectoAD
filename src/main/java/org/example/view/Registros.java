package org.example.view;

import org.example.controller.registrosController;
import org.example.model.empleados;
import org.example.model.registros;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Registros extends JDialog {
    private JPanel contentPane;
    private JButton btnFicharEntrada;
    private JComboBox cboxTelefono;  // Cambiado a cboxTelefono en lugar de cboxNif
    private JButton btnVolver;
    private JButton btnFicharSalida;
    private JLabel Telefono;

    private registrosController controller = new registrosController();


    public Registros() {
        setContentPane(contentPane);
        setModal(true);

        cargarTelefonos();

        btnFicharEntrada.addActionListener(e -> fichar(true));


        btnFicharSalida.addActionListener(e -> fichar(false));



        btnVolver.addActionListener(e -> dispose());
    }

    private void cargarTelefonos() {
        List<String> listaTelefonos = controller.obtenerListaTelefonos();

        cboxTelefono.removeAllItems();

        for (String telefono : listaTelefonos) {
            cboxTelefono.addItem(telefono);
        }
    }

    private void fichar(boolean esEntrada) {
        registros nuevoRegistro;
        try {
            String selectedTelefono = (String) cboxTelefono.getSelectedItem();
            empleados empleado = controller.obtenerEmpleadoPorTelefono(selectedTelefono);

            nuevoRegistro = new registros();
            nuevoRegistro.setFecha_Entrada(new Date());

            if (!esEntrada) {
                // Si es una ficha de salida, establecer la fecha de salida
                nuevoRegistro.setFecha_Salida(new Date());
            }

            // Asignar el empleado al registro
            nuevoRegistro.setTelefono(empleado);

            // Guardar el registro en la base de datos
            controller.guardarRegistro(nuevoRegistro);

            JOptionPane.showMessageDialog(this, "Registro guardado exitosamente");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el registro: " + ex.getMessage());
        }
    }

    private Date parseFecha(String fecha) throws ParseException {
        if (fecha.trim().isEmpty()) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        sdf.setLenient(false);

        return sdf.parse(fecha);
    }

    // Método para obtener el objeto empleados correspondiente al Teléfono seleccionado
    private empleados obtenerEmpleadoPorTelefono(String telefono) {
        return registrosController.obtenerEmpleadoPorTelefono(telefono);  // Cambiado a obtenerEmpleadoPorTelefono en lugar de obtenerEmpleadoPorNif
    }
}
