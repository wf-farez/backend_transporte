package org.tesis.backend_transporte.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idViaje;

    @Column(unique = true)
    private String codigoViaje;
    private String fecha;
    private String horaInicio;
    private String horaFin;
    private float precioNormal;
    private float precioDiferenciado;
    @ManyToOne
    private Empleado conductor;
    @ManyToOne
    private Empleado ayudante;
    @ManyToOne
    private Unidad unidad;

    @ManyToOne
    private Ruta ruta;

    public Viaje() {
    }

    public Viaje(Long idViaje, String codigoViaje, String fecha, String horaInicio, String horaFin, float precioNormal, float precioDiferenciado, Empleado conductor, Empleado ayudante, Unidad unidad, Ruta ruta) {
        this.idViaje = idViaje;
        this.codigoViaje = codigoViaje;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.precioNormal = precioNormal;
        this.precioDiferenciado = precioDiferenciado;
        this.conductor = conductor;
        this.ayudante = ayudante;
        this.unidad = unidad;
        this.ruta = ruta;
    }

    public Viaje(String codigoViaje, String fecha, String horaInicio, String horaFin, float precioNormal, float precioDiferenciado, Empleado conductor, Empleado ayudante, Unidad unidad, Ruta ruta) {
        this.codigoViaje = codigoViaje;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.precioNormal = precioNormal;
        this.precioDiferenciado = precioDiferenciado;
        this.conductor = conductor;
        this.ayudante = ayudante;
        this.unidad = unidad;
        this.ruta = ruta;
    }

    public Long getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Long idViaje) {
        this.idViaje = idViaje;
    }

    public String getCodigoViaje() {
        return codigoViaje;
    }

    public void setCodigoViaje(String codigoViaje) {
        this.codigoViaje = codigoViaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public float getPrecioNormal() {
        return precioNormal;
    }

    public void setPrecioNormal(float precioNormal) {
        this.precioNormal = precioNormal;
    }

    public float getPrecioDiferenciado() {
        return precioDiferenciado;
    }

    public void setPrecioDiferenciado(float precioDiferenciado) {
        this.precioDiferenciado = precioDiferenciado;
    }

    public Empleado getConductor() {
        return conductor;
    }

    public void setConductor(Empleado conductor) {
        this.conductor = conductor;
    }

    public Empleado getAyudante() {
        return ayudante;
    }

    public void setAyudante(Empleado ayudante) {
        this.ayudante = ayudante;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }


}
