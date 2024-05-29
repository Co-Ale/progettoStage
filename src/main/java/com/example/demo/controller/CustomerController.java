package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    //Crea nuovo cliente
    @PostMapping("/insert")
    public ResponseEntity<String> createCustomer(@RequestBody Customer model){
        try{
            customerService.insert(model);
           return new ResponseEntity<String>("Created", HttpStatus.CREATED);
        }catch(Exception e ){
           return new ResponseEntity<String>( e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
    }

    //DA METTERE di tipo Customer
    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        return customerService.findById(customerId);
    }

    /*
    @GetMapping("/all")
    public List<String> listCustomers(){
        return "/customer/all";
    }

     */
}