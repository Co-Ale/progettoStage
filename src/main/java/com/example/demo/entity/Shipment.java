package com.example.demo.entity;



import com.example.demo.utility.ShipmentState;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Package")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    long id_customer;

    @Column()
    String desc;
    @Column()
    String shipment_date;
    
    @Column()
    ShipmentState status;

    public Shipment(String desc, String shipment_date, long id_customer) {
        status =  ShipmentState.OPEN;
        this.desc = desc;
        this.shipment_date = shipment_date;
        this.id_customer = id_customer;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getShipment_date() {
        return shipment_date;
    }

    public void setShipment_date(String shipment_date) {
        this.shipment_date = shipment_date;
    }

    public long getId_customer() {
        return id_customer;
    }

    public void setId_customer(long id_customer) {
        this.id_customer = id_customer;
    }

    public ShipmentState getStatus() {
        return status;
    }

    public void setStatus(ShipmentState status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "desc='" + desc + '\'' +
                ", shipment_date='" + shipment_date + '\'' +
                ", id_customer=" + id_customer +
                ", status=" + status +
                '}';
    }
}
