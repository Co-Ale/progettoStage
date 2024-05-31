package com.example.demo.service;

import java.text.SimpleDateFormat;
//import java.io.*; 
//import java.util.List;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Shipment;
import com.example.demo.repo.RepoShipment;
import com.example.demo.utility.ShipmentState;


@Service
public class ShipmentService implements InterfaceShipmentService {
    @Autowired
    private RepoShipment repoShipment;

    @Override
    public Iterable<Shipment>  getAll() {
       return repoShipment.findAll();
    }


    @Override
    public void create(Shipment sp) {

        Date oggi = new Date();   // Data di oggi
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");   // Qui decido il formato di visualizzazione

        sp.setShipment_date(sdf.format( oggi ));
        sp.setStatus( ShipmentState.OPEN);
        repoShipment.save(sp);
    }
    @Override
    public void delete(long id) {
        repoShipment.deleteById(id);

    }
    @Override
    public List<Shipment> getAllOpen() {

        return repoShipment.findByStatus(ShipmentState.OPEN);
  
    }
    @Override
    public List<Shipment> getByClientId(long id) {
        return repoShipment.findBycustumerId(id);
        
    }
    @Override
    public void closeShipment(long id){
        Shipment sp = repoShipment.findById(id);
        sp.setStatus(ShipmentState.CLOSED);
        repoShipment.save(sp);
    
    }
    @Override
    public void update( Shipment shipment) {
        repoShipment.save(shipment);
        
    }
}
/*
    
         public List<Shipment> getAllOpen() {
        return repoShipment.findByStatus(ShipmentState.OPEN);
    // return repoShipment.findAll();
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getAllOpen'");
    }
        public List<Shipment> getByClientId(long id) {
            return repoShipment.findById_customer(id);
        }
        public void closeShipment(long id){
            Shipment sp = repoShipment.findById(id);
            sp.setStatus(ShipmentState.CLOSED);
            repoShipment.save(sp);
        
        }
   
     @Override
    public  Iterable<Shipment> findByCustomertId(long id) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'findById'");
        return  repoShipment.findById_customer(id);
        
    }
    
}*/
