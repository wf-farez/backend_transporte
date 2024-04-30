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
    private Long idConductor;
    private Long idAyudante;

    public Viaje() {
    }

    public Viaje(String codigoViaje, String fecha, String horaInicio, String horaFin, float precioNormal, float precioDiferenciado, Long idConductor, Long idAyudante) {
        this.codigoViaje = codigoViaje;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.precioNormal = precioNormal;
        this.precioDiferenciado = precioDiferenciado;
        this.idConductor = idConductor;
        this.idAyudante = idAyudante;
    }

    public Viaje(Long idViaje, String codigoViaje, String fecha, String horaInicio, String horaFin, float precioNormal, float precioDiferenciado, Long idConductor, Long idAyudante) {
        this.idViaje = idViaje;
        this.codigoViaje = codigoViaje;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.precioNormal = precioNormal;
        this.precioDiferenciado = precioDiferenciado;
        this.idConductor = idConductor;
        this.idAyudante = idAyudante;
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

    public Long getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Long idConductor) {
        this.idConductor = idConductor;
    }

    public Long getIdAyudante() {
        return idAyudante;
    }

    public void setIdAyudante(Long idAyudante) {
        this.idAyudante = idAyudante;
    }
}
