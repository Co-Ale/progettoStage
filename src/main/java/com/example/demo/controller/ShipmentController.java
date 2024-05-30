package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Shipment;

import com.example.demo.service.*;;


@RestController
@RequestMapping(value = "/shipment")
public class ShipmentController {
    @Autowired
    ShipmentService shipmentService;
    
    @PostMapping("/client/{clientId}")
    public ResponseEntity<String> createOrder(@PathVariable long clientId , @RequestBody Shipment model){
        try{
            model.setId_customer(clientId);
            shipmentService.create(model);
            return new ResponseEntity<String>("Created shipment id = " + model.getId_shipment() , HttpStatus.CREATED);
        }catch ( Exception e ){
            return new ResponseEntity<String>( e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/allOpenShipments")
    public Iterable<Shipment>  allOpenShipments() {//@RequestParam String param

        return shipmentService.getAllOpen();
    }
    
}
    /*
@PatchMapping("/closeShipment/{idShipment}")
    private ResponseEntity<String> shipmentClose(@PathVariable long id ){
        try{
            shipmentService.closeShipment(id);
            return new ResponseEntity<String>("shipment colse" , HttpStatus.OK );
        }catch ( Exception e ){
            return new ResponseEntity<String>( "id dosn't exist" + e.getMessage(),   HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/byClientId/{clientId}")
    public Iterable<Shipment>  getCustomerSchipment(@PathVariable long clientId){
        return shipmentService.findByCustomertId(clientId);
    }
    */
