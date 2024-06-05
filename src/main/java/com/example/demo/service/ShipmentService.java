package com.example.demo.service;

import java.text.SimpleDateFormat;
//import java.io.*; 
//import java.util.List;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Shipment;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Pallet;
import com.example.demo.repo.RepoCustomer;
import com.example.demo.repo.RepoPallet;
import com.example.demo.repo.RepoShipment;
import com.example.demo.utility.ShipmentState;


@Service
public class ShipmentService implements InterfaceShipmentService {
    @Autowired
    private RepoShipment repoShipment;
    @Autowired
    private RepoCustomer repoCustomer;
    @Autowired
    private RepoPallet repoPallet;

    @Override
    public Iterable<Shipment>  getAll() {
       return repoShipment.findAll();
    }


    @Override
    public long create(Long custumerId, Shipment sp) throws Exception {
        Optional<Customer> custumer =  repoCustomer.findById(custumerId);
        if(custumer.isPresent()){
            sp.setCustumer(custumer.get());
            Date oggi = new Date();   // Data di oggi
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");   // Qui decido il formato di visualizzazione
    
            sp.setShipment_date(sdf.format( oggi ));
            sp.setStatus( ShipmentState.OPEN);
            return repoShipment.save(sp).getId();
        }else{
            throw new Exception("custumer not present");
        }
        
       
    }
    @Override
    public void delete(Long id) {
        repoShipment.deleteById(id);

    }
    @Override
    public List<Shipment> getAllOpen() throws Exception {
        List<Shipment> allOpSp =repoShipment.findByStatus(ShipmentState.OPEN);
        if(!allOpSp.isEmpty()){
            return allOpSp;
        }else{
            throw new Exception("none Open shipment Exeption");
        }
        //return repoShipment.findByStatus(ShipmentState.OPEN);
        
    }
    @Override
    public List<Shipment> getByClientId(Long id)throws Exception  {
        //return repoShipment.findBycustumerId(id);
        Optional<Customer> customer = repoCustomer.findById(id);
        List<Shipment> spByClienId;
        if(  customer.isPresent()  ){
            spByClienId = repoShipment.findByCustomer_id(id);     
        }else{
            throw new Exception("Customer does not exist Exeption");
        }
        if(!spByClienId.isEmpty()){
            return spByClienId;
        }else{
            throw new Exception("Customer Shipment list empty Exeption");

        }
        
    }
    @Override
    public void closeShipment(Long id) throws Exception{
        Optional<Shipment>  sp =  repoShipment.findById(id);
        if(sp.isPresent()){
            sp.get().setStatus(ShipmentState.CLOSED);
            repoShipment.save(sp.get());
        }else{
            throw new Exception("Shipment not found");
        }

        
      
    
    }
    @Override
    public void update( Shipment shipment) {
        repoShipment.save(shipment);
        
    }

   
    public Set<Shipment> getShipmentsByPalletId(Long id)throws Exception  {
        //return repoShipment.findBycustumerId(id);
        Optional<Pallet> customer = repoPallet.findById(id);

        return customer.get().getShipment();

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
