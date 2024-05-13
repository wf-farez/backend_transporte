package org.tesis.backend_transporte.entity;

import jakarta.persistence.*;

@Entity
@Table
public class ParadaRuta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParadaRuta;
    @ManyToOne
    private Parada parada;

    @ManyToOne
    private Ruta ruta;

    private int orden;
    public ParadaRuta() {
    }

    public ParadaRuta(Long idParadaRuta, Parada parada, Ruta ruta, int orden) {
        this.idParadaRuta = idParadaRuta;
        this.parada = parada;
        this.ruta = ruta;
        this.orden = orden;
    }

    public ParadaRuta(Parada parada, Ruta ruta, int orden) {
        this.parada = parada;
        this.ruta = ruta;
        this.orden = orden;
    }

    public Long getIdParadaRuta() {
        return idParadaRuta;
    }

    public void setIdParadaRuta(Long idParadaRuta) {
        this.idParadaRuta = idParadaRuta;
    }

    public Parada getParada() {
        return parada;
    }

    public void setParada(Parada parada) {
        this.parada = parada;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
}
