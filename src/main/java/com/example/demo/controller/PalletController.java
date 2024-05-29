package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
public class PalletController {

    //@Autowired
    //PalletService palletService;


    @PostMapping("/shipment/{shipmentId}")
    public void createCustomer(Model model){

    }


    @GetMapping("/byPalletId/{palletId}")
    public String getCustomer(@PathVariable int palletId){
        return "/byPalletId/" + palletId;
    }


}