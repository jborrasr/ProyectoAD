package org.example.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class vacaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Vacaciones")
    private Long id_Vacaciones;
    @Column(name = "dia_Vacaciones")
    private Date dia_Vacaciones;

    @ManyToOne
    @JoinColumn(name = "dni")
    private empleados dni;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private departamentos id_departamento;

    public vacaciones() {
    }

    public vacaciones(Long id_Vacaciones, Date dia_Vacaciones, empleados dni, departamentos id_departamento) {
        this.id_Vacaciones = id_Vacaciones;
        this.dia_Vacaciones = dia_Vacaciones;
        this.dni = dni;
        this.id_departamento = id_departamento;
    }

    public Long getId_Vacaciones() {
        return id_Vacaciones;
    }

    public void setId_Vacaciones(Long id_Vacaciones) {
        this.id_Vacaciones = id_Vacaciones;
    }

    public Date getDia_Vacaciones() {
        return dia_Vacaciones;
    }

    public void setDia_Vacaciones(Date dia_Vacaciones) {
        this.dia_Vacaciones = dia_Vacaciones;
    }

    public empleados getDni() {
        return dni;
    }

    public void setDni(empleados dni) {
        this.dni = dni;
    }

    public departamentos getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(departamentos id_departamento) {
        this.id_departamento = id_departamento;
    }
}
