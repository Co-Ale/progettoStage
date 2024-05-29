package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pallet")
public class PackageController {

    //@Autowired
    //PalletService palletService;


    @PostMapping("/pallet/{palletId} ")
    public void PostPallet(Model model){

    }


    @GetMapping("/byPalletId/{palletId}")
    public String getPallet(@PathVariable int palletId){
        return "/byShipmentId/" + palletId;
    }
 

}