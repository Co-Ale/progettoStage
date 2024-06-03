package com.example.demo.repo;



import java.util.Optional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

//import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.demo.entity.Customer;




public interface RepoCustomer extends CrudRepository<Customer, Long>{

    Iterable<Customer> findByEmail(String email);
    @NonNull List<Customer> findAll();
    @NonNull  Optional<Customer> findById( @NonNull Long id); 
}

