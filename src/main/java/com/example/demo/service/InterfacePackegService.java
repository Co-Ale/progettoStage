package com.example.demo.service;

import org.apache.tomcat.util.openssl.pem_password_cb;

import com.example.demo.entity.Package;

public interface InterfacePackegService {

    public void create(long palletId, Package pack);
    public void update(Package pack);
    public void delete(long id);
    public Iterable<Package> byPalletId (long id);
}
