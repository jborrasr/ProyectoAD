package org.example.view;

import org.example.controller.departamentosController;
import org.example.model.departamentos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ModificarDepartamento extends javax.swing.JDialog {
    private JPanel contentPane;
    private JTextField txt_NombreDepartamento;
    private JTextField txt_Ubicacion;
    private JTextField txt_NumEmpleados;
    private JButton btnModificarDepartamento;
    private JButton btnVolver;

    private departamentosController controller;
    private departamentos departamentoSeleccionado;


    // Constructor para la inserción y modificación de departamentos
    public ModificarDepartamento(departamentosController controller, departamentos departamentoSeleccionado) {
        // Asigna un valor a this.controller
        this.controller = controller;
        this.departamentoSeleccionado = departamentoSeleccionado;

        setContentPane(contentPane);
        setModal(true);

        // Rellenar los campos con la información del departamento seleccionado
        llenarCampos();

        btnModificarDepartamento.addActionListener(this::actionPerformed);
        btnVolver.addActionListener(e -> dispose());
    }

    public ModificarDepartamento(departamentosController controller) {
        // Asigna un valor a this.controller
        this.controller = controller;

        setContentPane(contentPane);
        setModal(true);

        seleccionarDepartamento(); // Seleccionar automáticamente un departamento al abrir la ventana

        btnModificarDepartamento.addActionListener(this::actionPerformed);
        btnVolver.addActionListener(e -> dispose());
    }


    private void seleccionarDepartamento() {
        departamentos departamentoSeleccionado = obtenerDepartamentoSeleccionado();

        if (departamentoSeleccionado != null) {
            // Llenar los campos con la información del departamento seleccionado
            llenarCampos(departamentoSeleccionado);

            // Almacenar el departamento seleccionado para su posterior modificación
            this.departamentoSeleccionado = departamentoSeleccionado;

            // Habilita los campos
            habilitarCamposYBoton();
        }
    }

    private void llenarCampos(departamentos departamento) {
        txt_NombreDepartamento.setText(departamento.getNombreDespartamento());
        txt_Ubicacion.setText(departamento.getUbicacion());

    }

    static departamentos obtenerDepartamentoSeleccionado() {
        departamentosController controller = new departamentosController();

        // Obtener la lista de departamentos desde la base de datos o donde sea que los tengas almacenados
        List<departamentos> listaDepartamentos = controller.obtenerDepartamentosDesdeBD();

        // Crear un arreglo de Strings para mostrar en el diálogo de selección
        String[] opciones = new String[listaDepartamentos.size()];
        for (int i = 0; i < listaDepartamentos.size(); i++) {
            opciones[i] = listaDepartamentos.get(i).getNombreDespartamento();
        }

        // Mostrar un diálogo de selección
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona un departamento:",
                "Selección de Departamento",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones.length > 0 ? opciones[0] : null
        );

        // Obtener el departamento seleccionado y retornarlo
        if (seleccion != null) {
            for (departamentos departamento : listaDepartamentos) {
                if (departamento.getNombreDespartamento().equals(seleccion)) {
                    return departamento;
                }
            }
        }

        return null;  // Si no se selecciona ningún departamento
    }

    private void habilitarCamposYBoton() {
        txt_NombreDepartamento.setEnabled(true);
        // Habilita los demás campos

        btnModificarDepartamento.setEnabled(true);
    }

    private void llenarCampos() {
        txt_NombreDepartamento.setText(departamentoSeleccionado.getNombreDespartamento());
        txt_Ubicacion.setText(departamentoSeleccionado.getUbicacion());


    }

    private boolean camposVacios() {
        // Verificar si algún campo está vacío
        return txt_NombreDepartamento.getText().isEmpty() ||
                txt_Ubicacion.getText().isEmpty();
    }

    public void actionPerformed(ActionEvent e) {
        departamentos nuevoDepartamento;


        // Verificar campos vacíos
        if (camposVacios()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios. Completa todos los campos.");
            return;
        }

        // Si estamos modificando un departamento, utilizamos el objeto existente
        if (departamentoSeleccionado != null) {
            nuevoDepartamento = departamentoSeleccionado;
        } else {
            nuevoDepartamento = new departamentos();
        }

        nuevoDepartamento.setNombreDespartamento(txt_NombreDepartamento.getText());
        nuevoDepartamento.setUbicacion(txt_Ubicacion.getText());

        // Verificar que el controlador no sea nulo antes de invocar el método
        if (this.controller != null) {
            this.controller.modificarDepartamento(nuevoDepartamento);
        } else {
            System.err.println("Error: El controlador es nulo.");

        }

        // Cerrar la ventana después de insertar o modificar
        dispose();
    }
}
