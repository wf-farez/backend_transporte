package org.tesis.backend_transporte.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleado;
    @Column(unique = true)
    private String cedula;
    private String nombre;
    private String apellido;

    private String direccion;

    private String tipo;
    private String codigoAcceso;


    public Empleado() {
    }

    public Empleado(Long idEmpleado, String cedula, String nombre, String apellido, String direccion, String tipo, String codigoAcceso) {
        this.idEmpleado = idEmpleado;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.tipo = tipo;
        this.codigoAcceso = codigoAcceso;
    }

    public Empleado(String cedula, String nombre, String apellido, String direccion, String tipo, String codigo_acceso) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.tipo = tipo;
        this.codigoAcceso = codigoAcceso;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.idEmpleado = id_empleado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigoAcceso() {
        return codigoAcceso;
    }

    public void setCodigo_acceso(String codigoAcceso) {
        this.codigoAcceso = codigoAcceso;
    }
}
