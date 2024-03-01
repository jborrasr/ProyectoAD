package org.example.view;

import org.example.controller.empleadosController;
import org.example.model.empleados;
import org.example.util.HibernateUtil;

import javax.swing.*;

import static org.example.util.HibernateUtil.getSessionFactory;
import static org.example.view.ModificarEmpleados.obtenerEmpleadoSeleccionado;

public class MenuEmpleados extends JDialog {
    private JPanel contentPane;
    private JButton btnInsertarEmpleado;
    private JButton btnEliminarEmpleado;
    private JButton btnModificarEmpleado;
    private JButton btnVolver;

    public MenuEmpleados(empleadosController controller) {
        setContentPane(contentPane);
        setModal(true);

        btnInsertarEmpleado.addActionListener(e -> abrirMenuInsertar());
        btnModificarEmpleado.addActionListener(e -> abrirMenuModificar());
        btnEliminarEmpleado.addActionListener(e -> abrirMenuEliminar());
        btnVolver.addActionListener(e -> dispose());

    }

    private void abrirMenuInsertar() {
        InsertarEmpleados menuInsertar = new InsertarEmpleados();
        menuInsertar.pack();
        menuInsertar.setLocationRelativeTo(null);
        menuInsertar.setVisible(true);
    }

    private void abrirMenuModificar() {
        empleadosController controller = new empleadosController();
        empleados empleadoSeleccionado = obtenerEmpleadoSeleccionado();

        if (empleadoSeleccionado != null) {
            ModificarEmpleados modificarEmpleados = new ModificarEmpleados(controller, empleadoSeleccionado);
            modificarEmpleados.pack();
            modificarEmpleados.setLocationRelativeTo(null);
            modificarEmpleados.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún empleado.");
        }
    }

    private void abrirMenuEliminar() {
        empleadosController controller = new empleadosController();
        EliminarEmpleado menuEliminar = new EliminarEmpleado();
        menuEliminar.pack();
        menuEliminar.setLocationRelativeTo(null);
        menuEliminar.setVisible(true);
    }
}
