package org.tesis.backend_transporte.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCalificacion;

    private int calificacion;
    private String comentario;
    @ManyToOne
    private Viaje viaje;
    public Calificacion() {
    }

}
