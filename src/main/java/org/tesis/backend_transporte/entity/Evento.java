package org.tesis.backend_transporte.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvento;

    private String tipoEvento;
    private String descripcion;
    private String fecha;

    @ManyToOne
    private Viaje viaje;

    public Evento() {
    }

    public Evento(Long idEvento, String tipoEvento, String descripcion, String fecha, Viaje viaje) {
        this.idEvento = idEvento;
        this.tipoEvento = tipoEvento;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.viaje = viaje;
    }

    public Evento(String tipoEvento, String descripcion, String fecha, Viaje viaje) {
        this.tipoEvento = tipoEvento;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.viaje = viaje;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }
}
