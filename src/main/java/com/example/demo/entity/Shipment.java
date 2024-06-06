package com.example.demo.entity;



import java.util.HashSet;
import java.util.Set;

//import org.hibernate.annotations.ManyToAny;

import com.example.demo.utility.ShipmentState;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="Shipment")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Shipment {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipment_generator")
    @SequenceGenerator(name = "shipment_generator", sequenceName = "shipment_seq", initialValue=2)
    Long id;

    //@Column(name = "custumerId" ,nullable = true)
    //long custumerId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "customer_id" )
    private Customer customer;
    
    @ManyToMany(fetch = FetchType.LAZY)
    //@JsonIgnore
    @JoinTable(
        name = "Shipment_det",
        joinColumns = @JoinColumn (
            name = "ShipmentId"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "palletId"
        )
    )
    private Set<Pallet> pallets = new HashSet<>();
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

    public Shipment(String description, String shipment_date, Customer customer) {
        this.status =  ShipmentState.OPEN;
        this.description = description;
        this.shipment_date = shipment_date;
        this.customer = customer;
    }

    public Set<Pallet> getPallets(){
        return pallets;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return this.customer.getId();
    }

    // public void setCustumerId(long custumerId) {
    //    this.custumerId = custumerId;
    //}
    public void setCustumer(Customer customer){
        this.customer = customer;
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
                ", custumerId=" + customer.getId() +
                ", status=" + status +
                '}';
    }
}
