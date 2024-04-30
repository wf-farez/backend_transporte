package org.tesis.backend_transporte.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Parada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParada;

    @Column(unique = true)
    private String nombreParada;

    private String direccion;
    private float latitud;
    private float longitud;

    public Parada() {
    }

    public Parada(Long idParada, String nombreParada, String direccion, float latitud, float longitud) {
        this.idParada = idParada;
        this.nombreParada = nombreParada;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Parada(String nombreParada, String direccion, float latitud, float longitud) {
        this.nombreParada = nombreParada;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Long getIdParada() {
        return idParada;
    }

    public void setIdParada(Long idParada) {
        this.idParada = idParada;
    }

    public String getNombreParada() {
        return nombreParada;
    }

    public void setNombreParada(String nombreParada) {
        this.nombreParada = nombreParada;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }
}
