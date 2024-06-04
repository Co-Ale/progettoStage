package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pallet;
//import com.example.demo.entity.Shipment;
import com.example.demo.entity.Shipment;
import com.example.demo.repo.RepoPallet;
import com.example.demo.repo.RepoShipment;




@Service
public class PalletService {
    /*
    @Autowired
    private RepoShipmentDetails repoShipmentDetails; */
    @Autowired
    private RepoPallet repoPallet;
    @Autowired
    private RepoShipment repoShipment;

    public void create( Pallet pallet, Long shipmentId){

        Optional<Shipment> shipment =  repoShipment.findById(shipmentId);
        //pallet.setId(0);
        
        pallet.getShipment().add(shipment.get());
        shipment.get().getPallets().add(pallet);
        repoPallet.save(pallet);
        //Shipment_det sd = new Shipment_det();
        //sd.setidShipment_det(shipmentId);
        //sd.setIdPallet(pallet.getId());
        //repoShipmentDetails.save(sd);
    }

    /*
    public List<Pallet> getByShipmentId(Long sPId) throws Exception {
        List<Shipment_det> idList = repoShipmentDetails.findByIdShipment(sPId);
        List<Pallet> palList = new ArrayList<>();
        for (Shipment_det elemento : idList) {
            palList.add(repoPallet.findById(elemento.getIdPallet()).get());
        }
        if (!palList.isEmpty()) {
            return palList;                
        }else{
            throw new Exception ("Pallet not found by Shipment id Exeption");
        }
        
    }
     */

}
