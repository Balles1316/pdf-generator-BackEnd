package com.axiome.generadorpartetrabajo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incidenciaID;

    @Column(nullable = false)
    private LocalDate fechaIncidencia;

    @Column(nullable = false)
    private String descripcionIncidencia;

    @Column(nullable = false)
    private String estado; // Ejemplo: "Pendiente", "En progreso", "Resuelto"

    @ManyToOne
    @JoinColumn(name = "parking_id", nullable = false)
    private Parking parking;

    // Getters y setters

    public Long getIncidenciaID() {
        return incidenciaID;
    }

    public void setIncidenciaID(Long incidenciaID) {
        this.incidenciaID = incidenciaID;
    }

    public LocalDate getFechaIncidencia() {
        return fechaIncidencia;
    }

    public void setFechaIncidencia(LocalDate fechaIncidencia) {
        this.fechaIncidencia = fechaIncidencia;
    }

    public String getDescripcionIncidencia() {
        return descripcionIncidencia;
    }

    public void setDescripcionIncidencia(String descripcionIncidencia) {
        this.descripcionIncidencia = descripcionIncidencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }
}
