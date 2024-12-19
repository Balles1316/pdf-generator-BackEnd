package com.axiome.generadorpartetrabajo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ParteTrabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parteID;

    @Column(nullable = false)
    private LocalDate fechaParte;

    @Column(nullable = false)
    private String descripcionTrabajo;

    @Column(nullable = false)
    private int horasTrabajadas;

    @Column(nullable = false)
    private int numeroTecnicos;

    @ManyToOne
    @JoinColumn(name = "incidencia_id", nullable = false)
    private Incidencia incidencia;

    // Getters y setters

    public int getNumeroTecnicos() {
        return numeroTecnicos;
    }

    public void setNumeroTecnicos(int numeroTecnicos) {
        this.numeroTecnicos = numeroTecnicos;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public String getDescripcionTrabajo() {
        return descripcionTrabajo;
    }

    public void setDescripcionTrabajo(String descripcionTrabajo) {
        this.descripcionTrabajo = descripcionTrabajo;
    }

    public LocalDate getFechaParte() {
        return fechaParte;
    }

    public void setFechaParte(LocalDate fechaParte) {
        this.fechaParte = fechaParte;
    }

    public Long getParteID() {
        return parteID;
    }

    public void setParteID(Long parteID) {
        this.parteID = parteID;
    }

    public Incidencia getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(Incidencia incidencia) {
        this.incidencia = incidencia;
    }
}
