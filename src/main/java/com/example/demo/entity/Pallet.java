package com.example.demo.entity;


import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Pallet")
public class Pallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @ManyToMany( mappedBy = "pallets", fetch = FetchType.LAZY)
    private Set<Shipment> shipments = new HashSet<>();


    @OneToMany(mappedBy = "pallet",  fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Package> packegs;

    
    @Column()
    String description;
    
    @Column()
    int max_packages;
    Pallet (String description, int max_packages){
        this.description = description;
        this.max_packages = max_packages;
    }

    public Pallet() {
    }


    public Set<Package> getPackegs() {
        return this.packegs;
    }

    public Set<Shipment> getShipment(){
        return this.shipments;
    }
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMax_packages() {
        return this.max_packages;
    }

    public void setMax_packages(int max_packages) {
        this.max_packages = max_packages;
    }

    @Override
    public String toString() {
        return "Pallet{" +
                "desc='" + description + '\'' +
                ", max_packages=" + max_packages +
                '}';
    }
}
