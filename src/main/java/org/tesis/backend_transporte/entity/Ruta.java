package org.tesis.backend_transporte.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRuta;

    @ManyToOne
    private Compania compania;

    @Column(unique = true)
    private String nombreRuta;

    private String origenRuta;
    private String destinoRuta;

    public Ruta() {
    }

    public Ruta(Long idRuta, Compania compania, String nombreRuta, String origenRuta, String destinoRuta) {
        this.idRuta = idRuta;

        this.compania = compania;
        this.nombreRuta = nombreRuta;
        this.origenRuta = origenRuta;
        this.destinoRuta = destinoRuta;
    }

    public Ruta( Compania compania, String nombreRuta, String origenRuta, String destinoRuta) {

        this.compania = compania;
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




    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
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
