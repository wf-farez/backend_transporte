package org.tesis.backend_transporte.entity;

import jakarta.persistence.*;

@Entity
@Table
public class ParadaPreprogramada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParadaPreprogramada;

    private String descripcion;
    @ManyToOne
    private Viaje viaje;

    @ManyToOne
    private ParadaRuta paradaRuta;

    public ParadaPreprogramada() {
    }





}
