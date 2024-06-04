package com.example.demo.repo;



//import com.example.demo.entity.Customer;
//
import com.example.demo.entity.Shipment;
import com.example.demo.entity.Customer;


import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

import com.example.demo.utility.ShipmentState;




public interface RepoShipment extends CrudRepository<Shipment ,Long> {
    
    List<Shipment> findByStatus(ShipmentState status);
    List<Shipment> findByCustomer (Customer customer);
    @NonNull Optional<Shipment> findById(@NonNull Long id); 
    List<Shipment> findByCustomer_id(Long customer_id);
   // Iterable<Shipment> findB (String email);
}
