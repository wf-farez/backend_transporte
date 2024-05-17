package org.tesis.backend_transporte.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Asiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsiento;

    private int numeroAsiento;
    @ManyToOne
    private Unidad unidad;

    private Boolean estado;
    public Asiento() {
    }





}
