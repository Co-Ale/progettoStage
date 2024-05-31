package com.example.demo.service;



import java.util.List;

import com.example.demo.entity.Customer;


public interface InterfaceCustomerService {

    //public Collection<Customer> getAll();
    public Iterable<Customer> getAll();
    public void create(Customer costumer);
    public void update(long id, Customer costumer);
    public void delete(long id);
   

    //public Collection<Customer> get();
    public Customer findById(long id);
}
