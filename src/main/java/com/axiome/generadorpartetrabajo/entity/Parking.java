package com.axiome.generadorpartetrabajo.entity;

import jakarta.persistence.*;


@Entity
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parkingID;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private String provincia;

    @ManyToOne(optional = false) // Esto asegura que siempre se requiera un cliente asociado
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    //Getter y Setter
    public Long getParkingID() {
        return parkingID;
    }

    public void setParkingID(Long parkingID) {
        this.parkingID = parkingID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
