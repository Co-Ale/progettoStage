package com.example.demo.repo;



import com.example.demo.entity.Pallet;
//import com.example.demo.entity.Customer;
//
//import com.example.demo.entity.Shipment;


//import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Optional;

//import jakarta.annotation.Nonnull;

//import org.springframework.lang.NonNull;

import org.springframework.data.repository.CrudRepository;
//import java.util.List;
//import com.example.demo.utility.ShipmentState;
import org.springframework.lang.NonNull;




public interface RepoPallet extends CrudRepository<Pallet ,Long> {

    // List<Pallet> findByStatus(ShipmentState status);
    //  List<Pallet> findBycustumerId(long id);

    @NonNull Optional<Pallet> findById(@NonNull Long id);

    //List<Pallet> findAllBy(long id);
    //Iterable<Shipment> findById_customer(long id_customer);
    // Iterable<Shipment> findB (String email);
}
