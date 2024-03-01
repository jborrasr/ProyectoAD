package org.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nif")
    private Long nif;
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(unique = true, name = "dni")
    private String dni;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "fecha_contratacion")
    private LocalDate fechaContratacion;

    @Column(name = "salario")
    private double salario;

    @Column (name = "cargo")
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "id_Departamento")
    private departamentos id_departamento;



    public empleados() {
    }

    public empleados(Long nif, String nombre, String apellidos, String dni, String telefono, LocalDate fechaNacimiento, LocalDate fechaContratacion, double salario, String cargo, departamentos id_departamento) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
        this.cargo = cargo;
        this.id_departamento = id_departamento;
    }

    public Long getNif() {
        return nif;
    }

    public void setNif(Long nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Long getId_departamento() {
        return id_departamento.getId_Departamento();
    }

    public void setId_departamento(departamentos id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

}
