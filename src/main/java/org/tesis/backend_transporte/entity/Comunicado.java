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


    public Comunicado() {
    }

    public Comunicado(Long idComunicado, String descripcion, String fecha) {
        this.idComunicado = idComunicado;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Comunicado(String descripcion, String fecha) {
        this.descripcion = descripcion;
        this.fecha = fecha;
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
}
