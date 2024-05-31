package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Pallet;
import com.example.demo.service.PalletService;

@RestController
@RequestMapping(value = "")
public class PalletController {
    
    @Autowired
    private PalletService palletService;


    @PostMapping("/shipment/{shipmentId}")
    public void createCustomer(@RequestBody Pallet model, @PathVariable long shipmentId ){
        palletService.create(model, shipmentId );
    }


    @GetMapping("/byPalletId/{palletId}")
    public String getCustomer(@PathVariable int palletId){
        return "/byPalletId/" + palletId;
    }


}