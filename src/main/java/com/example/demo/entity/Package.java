package com.example.demo.entity;

import java.lang.Long;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Package")
public class Package {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;

    @Column(name ="idPallet")
    long idPallet;
    
    @Column(length = 100)
    String description;
    
    @Column()
    float weight;

   
    
    public Package(String description, float weight, long idPallet) {
        this.description = description;
        this.weight = weight;
        this.idPallet = idPallet;
    }

    public Package() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdPallet() {
        return this.idPallet;
    }

    public void setId_pallet(long idPallet) {
        this.idPallet = idPallet;
    }

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
                ", id_pallet=" + idPallet +
                '}';
    }
}
