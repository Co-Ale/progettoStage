package com.example.demo.service;

//import org.apache.tomcat.util.openssl.pem_password_cb;

import com.example.demo.entity.Package;

public interface InterfacePackegService {

    public void create(Long palletId, Package pack) throws Exception;
    public void update(Package pack);
    public void delete(Long id);
    public Iterable<Package> byPalletId (Long id) throws Exception;
}
