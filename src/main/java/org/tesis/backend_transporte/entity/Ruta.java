package org.tesis.backend_transporte.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRuta;

    private String nombreCompania;

    @Column(unique = true)
    private String nombreRuta;

    private String origenRuta;
    private String destinoRuta;

    public Ruta() {
    }

    public Ruta(Long idRuta, String nombreCompania, String nombreRuta, String origenRuta, String destinoRuta) {
        this.idRuta = idRuta;
        this.nombreCompania = nombreCompania;
        this.nombreRuta = nombreRuta;
        this.origenRuta = origenRuta;
        this.destinoRuta = destinoRuta;
    }

    public Ruta(String nombreCompania, String nombreRuta, String origenRuta, String destinoRuta) {
        this.nombreCompania = nombreCompania;
        this.nombreRuta = nombreRuta;
        this.origenRuta = origenRuta;
        this.destinoRuta = destinoRuta;
    }

    public Long getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Long idRuta) {
        this.idRuta = idRuta;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getOrigenRuta() {
        return origenRuta;
    }

    public void setOrigenRuta(String origenRuta) {
        this.origenRuta = origenRuta;
    }

    public String getDestinoRuta() {
        return destinoRuta;
    }

    public void setDestinoRuta(String destinoRuta) {
        this.destinoRuta = destinoRuta;
    }
}
