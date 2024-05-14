package org.tesis.backend_transporte.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUbicacion;

    private String latitud;
    private String longitud;
    @ManyToOne
    private Unidad unidad;
    public Ubicacion() {
    }

}
