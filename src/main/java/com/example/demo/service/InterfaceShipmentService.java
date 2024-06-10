package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.*;

public interface InterfaceShipmentService {

    
    public long create(Long costumerId , Shipment costumer)throws Exception;
    public void update(Shipment shipment);
    public void delete(Long id);
    public Shipment  getById(Long id)  throws Exception ;
    public Iterable<Shipment> getAll() throws Exception;
    public List<Shipment> getByClientId(Long id) throws Exception;
    public void closeShipment(Long id) throws Exception;
    public List<Shipment> getAllOpen()  throws Exception ;
    //public Collection<Customer> get();
    //public java.lang.Iterable<Shipment> findByCustomertId(long id);
    //  public void update(long id, Shipment shipment);

}
