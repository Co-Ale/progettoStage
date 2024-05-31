package com.example.demo.repo;



import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;


//import com.example.demo.entity.Customer;
import com.example.demo.entity.Shipment_det;



public interface RepoShipmentDetails extends CrudRepository<Shipment_det, Long>{

    //Iterable<Shipment_details> findByEmail(String email);

    Shipment_det findById(long id); 
}

