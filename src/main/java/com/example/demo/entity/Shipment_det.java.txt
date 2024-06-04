package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Shipment_Det")
public class Shipment_det {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    
   // @Id
    @Column(name = "idPallet" )
    long idPallet;
    @Column(name = "idShipment" ,nullable = false  )
    long idShipment;

    public Shipment_det() {
    }

    public Shipment_det(long idShipment, long idPallet) {
        this.idShipment = idShipment;
        this.idPallet = idPallet;
    }

    public long getidShipment_det() {
        return idShipment;
    }

    public void setidShipment_det(long idShipment) {
        this.idShipment = idShipment;
    }

    public long getIdPallet() {
        return idPallet;
    }

    public void setIdPallet(long idPallet) {
        this.idPallet = idPallet;
    }

    @Override
    public String toString() {
        return "Shipment_details{" +
                "idShipment_details=" + id +
                ", idPallet=" + idPallet +
                '}';
    }
}
