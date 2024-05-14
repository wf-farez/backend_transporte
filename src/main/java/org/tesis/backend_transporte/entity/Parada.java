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
    private String latitud;
    private String longitud;

    public Parada() {
    }

    public Parada(Long idParada, String nombreParada, String direccion, String latitud, String longitud) {
        this.idParada = idParada;
        this.nombreParada = nombreParada;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Parada(String nombreParada, String direccion, String latitud, String longitud) {
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

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
