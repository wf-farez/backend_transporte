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

    public Asiento(Long idAsiento, int numeroAsiento, Unidad unidad, Boolean estado) {
        this.idAsiento = idAsiento;
        this.numeroAsiento = numeroAsiento;
        this.unidad = unidad;
        this.estado = estado;
    }


    public Asiento(int numeroAsiento, Unidad unidad, Boolean estado) {
        this.numeroAsiento = numeroAsiento;
        this.unidad = unidad;
        this.estado = estado;
    }

    public Long getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(Long idAsiento) {
        this.idAsiento = idAsiento;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
