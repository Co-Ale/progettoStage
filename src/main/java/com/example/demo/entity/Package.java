package com.example.demo.entity;

import java.lang.Long;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="Package")
public class Package {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "pallet_id" )
    private Pallet pallet;

    //@Column(name ="idPallet")
    //long idPallet;
    
    @Column(length = 100)
    String description;
    
    @Column()
    float weight;

   
    
    public Package(String description, float weight, Pallet pallet) {
        this.description = description;
        this.weight = weight;
        this.pallet = pallet;
    
    }

    

    public Package() {
    }
    
    public void setPallet(Pallet pallet) {
        this.pallet = pallet;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pallet getPallet() {
        return this.pallet;
    }
    /*
    public void setId_pallet(long idPallet) {
        this.idPallet = idPallet;
    }
     */
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getWeight() {
        return this.weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Package{" +
                "desc='" + description + '\'' +
                ", weight=" + weight +
                ", id_pallet=" + pallet.getId() +
                '}';
    }
}
