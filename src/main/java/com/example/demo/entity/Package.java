package com.example.demo.entity;


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
    long id_package;

    @Column(name ="idPallet")
    long id_pallet;
    
    @Column(length = 100)
    String description;
    
    @Column()
    float weight;
    
    
    public Package(String description, float weight, long id_pallet) {
        this.description = description;
        this.weight = weight;
        this.id_pallet = id_pallet;
    }

    public Package() {
    }

    public String getDesc() {
        return description;
    }

    public float getWeight() {
        return weight;
    }

    public long getId_pallet() {
        return id_pallet;
    }

    public void setDesc(String description) {
        this.description = description;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setId_pallet(long id_pallet) {
        this.id_pallet = id_pallet;
    }

    @Override
    public String toString() {
        return "Package{" +
                "desc='" + description + '\'' +
                ", weight=" + weight +
                ", id_pallet=" + id_pallet +
                '}';
    }
}
