package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Package;


import com.example.demo.service.PackageService;

import org.springframework.web.bind.annotation.*;
import java.lang.Long;


@RestController
@RequestMapping(value = "/package")
public class PackageController {

    @Autowired
    PackageService packageService;


    @PostMapping("/{palletId}")
    public ResponseEntity<?> PostPallet(@PathVariable Long palletId, @RequestBody Package model){
        try {
            
            packageService.create(palletId,model);
            
            return new ResponseEntity<> ( "created package id = "+ model.getId() , HttpStatus.CREATED );
    
        } catch (Exception e) {
            return new ResponseEntity<> (e.getMessage() ,HttpStatus.BAD_REQUEST );

        }
    }


    @GetMapping("/byPalletId/{palletId}")
    public  ResponseEntity<?>  getPallet(@PathVariable Long palletId){
        try {
            return new ResponseEntity<>(packageService.byPalletId(palletId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<> (e.getMessage() ,HttpStatus.BAD_REQUEST );
            
        }
        //return "/byShipmentId/" + palletId;
    }
 

}