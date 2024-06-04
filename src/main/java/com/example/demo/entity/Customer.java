package com.example.demo.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
     /*
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "custumerId")
    private List<Shipment> emails;
    */
    @OneToMany(mappedBy = "customer",  fetch = FetchType.LAZY)
   // @JoinColumn(name = "")
    private List<Shipment> shipments;

    @Column(name="email", length=50,nullable=true, unique=true)
    String email;

    @Column(name="address", length=50, nullable=true, unique=false)
    String address;

    public Customer(Long id, String email, String address) {
        this.id = id;
        this.email = email;
        this.address = address;
    }

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
