package com.example.demo.repo;


import com.example.demo.entity.Customer;
//import com.example.demo.entity.Shipment;
import com.example.demo.entity.Shipment;
import org.springframework.data.repository.CrudRepository;



public interface RepoShipment extends CrudRepository<Shipment,Long> {

    
    Shipment findById(long id); 
    //Iterable<Shipment> findById_customer(long id_customer);
   // Iterable<Shipment> findB (String email);
}
