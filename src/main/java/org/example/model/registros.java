package org.example.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class registros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Registro")
    private Long id_Registro;
    @Column(name = "fecha_Entrada")
    private Date fecha_Entrada;

    @Column(name = "fecha_Salida")
    private Date fecha_Salida;

    @Column (name = "descanso")
    private boolean descanso;

    @ManyToOne
    @JoinColumn(name = "dni")
    private empleados dni;

    public registros() {
    }

    public registros(Long id_Registro, Date fecha_Entrada, Date fecha_Salida, boolean descanso, empleados dni) {
        this.id_Registro = id_Registro;
        this.fecha_Entrada = fecha_Entrada;
        this.fecha_Salida = fecha_Salida;
        this.descanso = descanso;
        this.dni = dni;
    }

    public Long getId_Registro() {
        return id_Registro;
    }

    public void setId_Registro(Long id_Registro) {
        this.id_Registro = id_Registro;
    }

    public Date getFecha_Entrada() {
        return fecha_Entrada;
    }

    public void setFecha_Entrada(Date fecha_Entrada) {
        this.fecha_Entrada = fecha_Entrada;
    }

    public Date getFecha_Salida() {
        return fecha_Salida;
    }

    public void setFecha_Salida(Date fecha_Salida) {
        this.fecha_Salida = fecha_Salida;
    }

    public boolean isDescanso() {
        return descanso;
    }

    public void setDescanso(boolean descanso) {
        this.descanso = descanso;
    }

    public empleados getDni() {
        return dni;
    }

    public void setDni(empleados dni) {
        this.dni = dni;
    }
}
