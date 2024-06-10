package com.example.utility;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Customer;
import com.example.demo.repo.RepoCustomer;
import com.example.demo.service.CustomerService;

public class  GetEntityForTest {
    @Autowired
    CustomerService customerService;
	@Autowired
	RepoCustomer repoCustomer ;

    public static Customer crateCustomer(){
        Customer c = new Customer();
        c.setEmail("email12");
        c.setAddress("qui");
        //c.setId(2L);
        return c;
    }
   
}
