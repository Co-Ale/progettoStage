package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Shipment")
public class Shipment {

    @PostMapping("/client/{clientId}")
    public void createOrder(Model model){

    }
    @PatchMapping("/shipment/{shipmentId}")
    public void updateShipment(){

    }


    @GetMapping("/byPalletId/{palletId}")
    public String getCustomer(@PathVariable int palletId){
        return "/byPalletId/" + palletId;
    }

}