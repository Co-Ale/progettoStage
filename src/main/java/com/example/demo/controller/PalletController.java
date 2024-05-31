package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Pallet;
//import com.example.demo.entity.Shipment;
import com.example.demo.service.PalletService;

@RestController
@RequestMapping(value = "")
public class PalletController {
    
    @Autowired
    private PalletService palletService;


    @PostMapping("/shipment/{shipmentId}")
    public  ResponseEntity<String>  createCustomer(@RequestBody Pallet model, @PathVariable long shipmentId ){
        try{
            palletService.create(model, shipmentId );
            return new ResponseEntity<String> ("Created pallet id = " + model.getId() , HttpStatus.CREATED); 
        }catch(Exception e){
           return new ResponseEntity<String>( e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        }



    @GetMapping("/byShipmentId/{byShipmentId}")
    public Iterable<Pallet> getByShipmentId(@PathVariable int byShipmentId){
       return palletService.getByShipmentId(byShipmentId);
       // return "/byPalletId/" + palletId;
    }


}