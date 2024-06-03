package com.example.demo.entity;



import org.hibernate.annotations.ManyToAny;

import com.example.demo.utility.ShipmentState;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="Shipment")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    long id;

    
    
    @Column(name = "custumerId" ,nullable = true)
    long custumerId;
    @ManyToOne
    @JoinColumn(name =  "userId")
    private Customer user;
    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custumerId")
    private Customer custumerId;
     */
    
    @Column(name = "description" )
    String description;
    @Column(nullable = true)
    String shipment_date;
    
    @Column( name =  "status",nullable = true)
    @Enumerated(EnumType.STRING)
    ShipmentState status;
    
    
    public Shipment(){
    }

    public Shipment(String description, String shipment_date, long custumerId) {
        this.status =  ShipmentState.OPEN;
        this.description = description;
        this.shipment_date = shipment_date;
        this.custumerId = custumerId;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustumerId() {
        return this.custumerId;
    }

    public void setCustumerId(long custumerId) {
        this.custumerId = custumerId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShipment_date() {
        return this.shipment_date;
    }

    public void setShipment_date(String shipment_date) {
        this.shipment_date = shipment_date;
    }

    public ShipmentState getStatus() {
        return this.status;
    }

    public void setStatus(ShipmentState status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Shipment{" +
                "desc='" + description + '\'' +
                ", shipment_date='" + shipment_date + '\'' +
                ", custumerId=" + custumerId +
                ", status=" + status +
                '}';
    }
}
