package com.example.demo.service;



//import java.util.List;

import com.example.demo.entity.Customer;


public interface InterfaceCustomerService {

    //public Collection<Customer> getAll();
    public Iterable<Customer> getAll() throws Exception;
    public void create(Customer costumer);
    public void update(Long id, Customer costumer);
    public void delete(Long id);
   

    //public Collection<Customer> get();
    public Customer getById(Long id) throws Exception;
}
