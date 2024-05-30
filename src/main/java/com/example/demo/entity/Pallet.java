package com.example.demo.entity;


//import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Pallet")
public class Pallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column()
    String description;
    
    int max_packages;
    Pallet (String description, int max_packages){
        this.description = description;
        this.max_packages = max_packages;
    }

    public Pallet() {
    }

    public String getDesc() {
        return description;
    }

    public int getMax_packages() {
        return max_packages;
    }

    public void setDesc(String description) {
        this.description = description;
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
