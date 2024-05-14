package org.tesis.backend_transporte.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Comunicado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComunicado;

    private String descripcion;
    private String fecha;
    @ManyToOne
    private Viaje viaje;
    public Comunicado() {
    }

    public Comunicado(Long idComunicado, String descripcion, String fecha, Viaje viaje) {
        this.idComunicado = idComunicado;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.viaje = viaje;
    }

    public Comunicado(String descripcion, String fecha, Viaje viaje) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.viaje = viaje;
    }


    public Long getIdComunicado() {
        return idComunicado;
    }

    public void setIdComunicado(Long idComunicado) {
        this.idComunicado = idComunicado;
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
