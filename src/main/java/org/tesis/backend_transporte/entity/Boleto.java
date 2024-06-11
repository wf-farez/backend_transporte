package org.tesis.backend_transporte.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBoleto;

    private String numeroCedula;
    @ManyToOne
    private Asiento asiento;
    @ManyToOne
    private Viaje viaje;
    public Boleto() {
    }

    public Boleto(Long idBoleto, String numeroCedula, Asiento asiento, Viaje viaje) {
        this.idBoleto = idBoleto;
        this.numeroCedula = numeroCedula;
        this.asiento = asiento;
        this.viaje = viaje;
    }

    public Boleto(String numeroCedula, Asiento asiento, Viaje viaje) {
        this.numeroCedula = numeroCedula;
        this.asiento = asiento;
        this.viaje = viaje;
    }

    public Long getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Long idBoleto) {
        this.idBoleto = idBoleto;
    }

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }
}
