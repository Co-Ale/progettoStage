package com.example.demo.service;

import java.util.Set;

import com.example.demo.entity.Pallet;

public interface InterfacePalletService {
    public void create( Pallet pallet, Long shipmentId) throws Exception;
    public Set<Pallet> getByShipmentId(Long sPId) throws Exception ;

}
