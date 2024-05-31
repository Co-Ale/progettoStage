package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.*;

public interface InterfaceShipmentService {

    
    public void create(Shipment costumer);
    public void update(Shipment shipment);
    public void delete(long id);
  
    public Iterable<Shipment> getAll();
    public List<Shipment> getByClientId(long id);
    public void closeShipment(long id);
    public List<Shipment> getAllOpen();
    //public Collection<Customer> get();
    //public java.lang.Iterable<Shipment> findByCustomertId(long id);
    //  public void update(long id, Shipment shipment);

}
