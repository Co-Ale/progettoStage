package com.example.demo.service;

import com.example.demo.entity.*;

public interface InterfaceShipmentService {

    public Iterable<Shipment> getAll();
    public void create(Shipment costumer);
  //  public void update(long id, Shipment shipment);
    public void delete(long id);
    //public Collection<Customer> get();
    //public java.lang.Iterable<Shipment> findByCustomertId(long id);
} 