package org.example.view;

import javax.swing.*;

public class ModificarEmpleados extends javax.swing.JDialog {
private javax.swing.JPanel contentPane;
    private JTextField txt_Nombre;
    private JTextField txt_Apellidos;
    private JTextField txt_Dni;
    private JTextField txt_Telefono;
    private JTextField txt_FechaNacimiento;
    private JTextField txt_FechaInicio;
    private JTextField txt_Sueldo;
    private JTextField txt_Cargo;
    private JComboBox cbox_Departamento;
    private JButton btnModificarEmpleado;
    private JButton btnVolver;

    public ModificarEmpleados() {
        setContentPane(contentPane);
        setModal(true);

        btnVolver.addActionListener(e -> dispose());
    }
}
