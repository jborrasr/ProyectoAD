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
    @JoinColumn(name = "telefono")
    private empleados telefono;

    public registros() {
    }

    public registros(Long id_Registro, Date fecha_Entrada, Date fecha_Salida, boolean descanso, empleados telefono) {
        this.id_Registro = id_Registro;
        this.fecha_Entrada = fecha_Entrada;
        this.fecha_Salida = fecha_Salida;
        this.descanso = descanso;
        this.telefono = telefono;

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




    public empleados getTelefono() {
        return telefono;
    }

    public void setTelefono(empleados telefono) {
        this.telefono = telefono;
    }


}
