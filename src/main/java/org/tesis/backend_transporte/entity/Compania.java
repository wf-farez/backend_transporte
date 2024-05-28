package org.tesis.backend_transporte.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table
public class Compania {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompania;

    private String nombreCompania;

    private String direccion;

    public Compania() {
    }

    public Compania(Long idCompania, String nombreCompania, String direccion) {
        this.idCompania = idCompania;
        this.nombreCompania = nombreCompania;
        this.direccion = direccion;
    }

    public Compania(Long idCompania) {
        this.idCompania = idCompania;
    }

    public Compania(String nombreCompania, String direccion) {
        this.nombreCompania = nombreCompania;
        this.direccion = direccion;
    }

    public Long getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(Long idCompania) {
        this.idCompania = idCompania;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
