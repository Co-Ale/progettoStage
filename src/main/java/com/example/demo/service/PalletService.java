package com.example.demo.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pallet;
//import com.example.demo.entity.Shipment;
import com.example.demo.entity.Shipment;
import com.example.demo.repo.RepoPallet;
import com.example.demo.repo.RepoShipment;




@Service
public class PalletService implements InterfacePalletService {
    /*
    @Autowired
    private RepoShipmentDetails repoShipmentDetails; */
    @Autowired
    private RepoPallet repoPallet;
    @Autowired
    private RepoShipment repoShipment;

    @Override
    public void create( Pallet pallet, Long shipmentId) throws Exception {

        Optional<Shipment> shipment =  repoShipment.findById(shipmentId);
        //pallet.setId(0);
        if (shipment.isPresent()) {
            pallet.getShipment().add(shipment.get());
            shipment.get().getPallets().add(pallet);
            repoPallet.save(pallet);
        }else{
            throw new Exception("Shipment not found Exception");
        }
      
        //Shipment_det sd = new Shipment_det();
        //sd.setidShipment_det(shipmentId);
        //sd.setIdPallet(pallet.getId());
        //repoShipmentDetails.save(sd);
    }
    @Override
    public Set<Pallet> getByShipmentId(Long sPId) throws Exception {
        Optional<Shipment> shipment = repoShipment.findById(sPId);
        if(shipment.isPresent()){
            return shipment.get().getPallets();
        }else{
            throw new Exception("Shipment not found Exception");
        }
    }


    /*
    @Override
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
