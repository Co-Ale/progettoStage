package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Package;
import com.example.demo.entity.Pallet;

import com.example.demo.repo.RepoPackage;
import com.example.demo.repo.RepoPallet;


@Service
public class PackageService implements InterfacePackegService {
    @Autowired
    private RepoPackage repoPackage;
    @Autowired
    private RepoPallet repoPallet;

    @Override
    public void create(long id, Package pack) {
        ;
       // if( repoPallet.findById(id).getMax_packages()<   )
       // repoPackage.save(null)
        
    }

    @Override
    public void update(Package shipment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Iterable<Package> byPalletId(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'byPalletId'");
    }
    
}
