package org.tesis.backend_transporte.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnidad;

    @Column(unique = true)
    private String codigoUnidad;

    private String placa;
    private int cantidadAsientos;
    private String estado;

    public Unidad() {
    }

    public Unidad(Long idUnidad, String codigoUnidad, String placa, int cantidadAsientos, String estado) {
        this.idUnidad = idUnidad;
        this.codigoUnidad = codigoUnidad;
        this.placa = placa;
        this.cantidadAsientos = cantidadAsientos;
        this.estado = estado;
    }

    public Unidad(String codigoUnidad, String placa, int cantidadAsientos, String estado) {
        this.codigoUnidad = codigoUnidad;
        this.placa = placa;
        this.cantidadAsientos = cantidadAsientos;
        this.estado = estado;
    }

    public Long getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Long idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getCodigoUnidad() {
        return codigoUnidad;
    }

    public void setCodigoUnidad(String codigoUnidad) {
        this.codigoUnidad = codigoUnidad;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
