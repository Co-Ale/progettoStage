package com.example.demo.repo;



import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;


import com.example.demo.entity.Customer;



public interface RepoCustomer extends CrudRepository<Customer, Long>{

    Iterable<Customer> findByEmail(String email);

    Customer findById(long id); 
}

