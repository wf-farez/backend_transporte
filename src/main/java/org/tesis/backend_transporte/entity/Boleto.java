package org.tesis.backend_transporte.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBoleto;

    private Long codigoBoleto;
    @ManyToOne
    private Asiento asiento;
    @ManyToOne
    private Viaje viaje;
    public Boleto() {
    }





}
