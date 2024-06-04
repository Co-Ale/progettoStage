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
            //model.setCustumerId(clientId);
            shipmentService.create(clientId ,model);
            return new ResponseEntity<String>("Created shipment id = " + model.getId() , HttpStatus.CREATED);
        }catch ( Exception e ){
            return new ResponseEntity<String>( e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/allOpenShipments")
    public ResponseEntity<?>  allOpenShipments() {//@RequestParam String param
        try{
            return new ResponseEntity<>( shipmentService.getAllOpen(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>( e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/allShipments")
    public ResponseEntity<?>  allShipments() {//@RequestParam String param
        try {
            return new ResponseEntity<>( shipmentService.getAll() , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>( e.getMessage(), HttpStatus.NOT_FOUND);
        }
        
    }
    @PatchMapping("/closeShipment/{idShipment}")
    private ResponseEntity<String> shipmentClose(@PathVariable Long idShipment ){
        try{
            shipmentService.closeShipment(idShipment);
            return new ResponseEntity<String>("shipment colse" , HttpStatus.OK );
        }catch ( Exception e ){
            return new ResponseEntity<String>( "Error shipment fail to colse"+ e.getMessage(),   HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/byClientId/{clientId}")
    public ResponseEntity<?>  getCustomerSchipment(@PathVariable long clientId){
        try{
            return new ResponseEntity<>(shipmentService.getByClientId(clientId) ,HttpStatus.OK );
        }catch ( Exception e ){
            return new ResponseEntity<String>( "Error shipment fail to colse"+ e.getMessage(),   HttpStatus.BAD_REQUEST);
        }
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
