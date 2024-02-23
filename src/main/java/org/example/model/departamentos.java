package org.example.model;

import jakarta.persistence.*;

@Entity
public class departamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Departamento")
    private Long id_Departamento;
    @Column(name = "nombreDepartamento")
    private String nombreDespartamento;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "num_Empleados")
    private int num_Empleados;

    public departamentos() {
    }

    public Long getId_Departamento() {
        return id_Departamento;
    }

    public void setId_Departamento(Long id_Departamento) {
        this.id_Departamento = id_Departamento;
    }

    public String getNombreDespartamento() {
        return nombreDespartamento;
    }

    public void setNombreDespartamento(String nombreDespartamento) {
        this.nombreDespartamento = nombreDespartamento;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getNum_Empleados() {
        return num_Empleados;
    }

    public void setNum_Empleados(int num_Empleados) {
        this.num_Empleados = num_Empleados;
    }


    public departamentos(Long id_Departamento, String nombreDespartamento, String ubicacion, int num_Empleados) {
        this.id_Departamento = id_Departamento;
        this.nombreDespartamento = nombreDespartamento;
        this.ubicacion = ubicacion;
        this.num_Empleados = num_Empleados;
    }


}
