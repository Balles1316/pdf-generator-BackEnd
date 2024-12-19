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
    private String localidad;

    @Column(nullable = false)
    private String provincia;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private double codigoParking;

    @ManyToOne(optional = false) // Esto asegura que siempre se requiera un cliente asociado
    @JoinColumn(name = "clienteID", nullable = false)
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

    public String getLocalidad() {return localidad;}

    public void setLocalidad(String localidad) {this.localidad = localidad;}

    public double getCodigoParking() {return codigoParking;}

    public void setCodigoParking(double codigoParking) {this.codigoParking = codigoParking;}

    public String getDireccion() {return direccion;}

    public void setDireccion(String direccion) {this.direccion = direccion;}
}
