package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Package")
public class Shipment_details {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    
   // @Id
    long idPallet;

    public Shipment_details(long id, long idPallet) {
        this.id = id;
        this.idPallet = idPallet;
    }

    public long getidShipment_details() {
        return id;
    }

    public void setidShipment_details(long id) {
        this.id = id;
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
