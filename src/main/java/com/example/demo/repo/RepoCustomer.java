package com.example.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.example.demo.entity.Customer;

public interface RepoCustomer extends CrudRepository<Customer, Long> {
  
  List<Customer> findByEmail(String email);

  Customer findById(long id);
}

