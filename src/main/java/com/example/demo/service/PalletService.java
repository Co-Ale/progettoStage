package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pallet;
//import com.example.demo.entity.Shipment;
import com.example.demo.entity.Shipment_det;
import com.example.demo.repo.RepoShipmentDetails;
import com.example.demo.repo.RepoPallet;




@Service
public class PalletService {
    @Autowired
    private RepoShipmentDetails repoShipmentDetails;
    @Autowired
    private RepoPallet repoPallet;

    public void create( Pallet pallet, long shipmentId){

        pallet.setId(0);
        repoPallet.save(pallet);
        Shipment_det sd = new Shipment_det();
        sd.setidShipment_det(shipmentId);
        sd.setIdPallet(pallet.getId());
        repoShipmentDetails.save(sd);
        
    }
    
    public List<Pallet> getByShipmentId(long sPId) {
        List<Shipment_det> idList = repoShipmentDetails.findByIdShipment(sPId);
        List<Pallet> palList = new ArrayList<>();
        for (Shipment_det elemento : idList) {
            palList.add(repoPallet.findById(elemento.getIdPallet()));
        }
        return palList;
    }

}
