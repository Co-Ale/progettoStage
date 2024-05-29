package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.example.demo.entity.Shipment;
import com.example.demo.repo.RepoShipment;



//import java.util.List;


@Service
public class ShipmentService implements InterfaceShipmentService {
    @Autowired
    private RepoShipment repoShipment;

    @Override
    public Iterable<Shipment>  getAll() {
        // TODs Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'getAll'");
       return repoShipment.findAll();
    }
   /*  public Iterable<Shipment>  allOpenShipment() {
     //   getAll()
     //   Iterable<Shipment> openn new 
        
    

    }*/
    @Override
    public void create(Shipment sp) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'create'");
       
        repoShipment.save(sp);
    }

  

    @Override
    public void delete(long id) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
   
}
/*
     @Override
    public  Iterable<Shipment> findByCustomertId(long id) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'findById'");
        return  repoShipment.findById_customer(id);
        
    }
    
}*/
