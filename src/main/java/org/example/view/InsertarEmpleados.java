package org.example.view;

import javax.swing.*;

public class InsertarEmpleados extends javax.swing.JDialog {
private javax.swing.JPanel contentPane;
    private JTextField txt_Nombre;
    private JTextField txt_Apellidos;
    private JButton btnInsertarEmpleado;
    private JTextField txt_Dni;
    private JTextField txt_Telefono;
    private JTextField txt_FechaNacimiento;
    private JTextField txt_FechaInicio;
    private JTextField txt_Sueldo;
    private JTextField txt_Cargo;
    private JComboBox cbox_Departamento;
    private JButton btnVolver;


    public InsertarEmpleados() {
        setContentPane(contentPane);
        setModal(true);


        btnVolver.addActionListener(e -> dispose());

    }
}
