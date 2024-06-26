package org.tesis.backend_transporte.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idViaje;
    @Column(unique = true)
    private String codigoViaje;
    private Date fecha;
    private Date horaInicio;
    private Date horaFin;
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

    private Boolean estado;

    public Viaje() {
    }

    public Viaje(Long idViaje, String codigoViaje, Date fecha, Date horaInicio, Date horaFin, float precioNormal, float precioDiferenciado, Empleado conductor, Empleado ayudante, Unidad unidad, Ruta ruta, Boolean estado) {
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
        this.estado = estado;
    }

    public Viaje(String codigoViaje, Date fecha, Date horaInicio, Date horaFin, float precioNormal, float precioDiferenciado, Empleado conductor, Empleado ayudante, Unidad unidad, Ruta ruta, Boolean estado) {
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
        this.estado = estado;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
