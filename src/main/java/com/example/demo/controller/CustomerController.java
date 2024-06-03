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
            customerService.create(model);
            return new ResponseEntity<String>("Created id = " + model.getId() , HttpStatus.CREATED);
        }catch(Exception e ){
           return new ResponseEntity<String>( e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
    }

    //DA METTERE di tipo Customer
    @GetMapping("/{customerId}")
    public ResponseEntity<?> getCustomer(@PathVariable long customerId){
        try{
            return new ResponseEntity<Customer>( customerService.findById(customerId), HttpStatus.FOUND);
        }catch(Exception e ){
            return new ResponseEntity<String>( e.getMessage(), HttpStatus.NOT_FOUND);
        }
        
    }

    @GetMapping("/all")
    public ResponseEntity<?>  getAll(){
        try{
            return new ResponseEntity<>( customerService.getAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>( e.getMessage(), HttpStatus.NOT_FOUND);
        }
        
    }
    /*
    @GetMapping("/all")
    public List<String> listCustomers(){
        return "/customer/all";
    }

     */
}