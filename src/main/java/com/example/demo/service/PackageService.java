package com.example.demo.service;


import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    public void create( Long palletId, Package pack) throws Exception {
        Optional<Pallet> pallet = repoPallet.findById(palletId);
        if(pallet.isPresent()){
            pallet.get().getPackegs().add(pack);
            pack.setPallet(pallet.get());
            repoPackage.save(pack);
        }else{
            throw new Exception("Pallet not found");
        }
        
       // if( repoPallet.findById(id).getMax_packages()<   )
       // repoPackage.save(null)
        
    }
    @Override
    public Set<Package> byPalletId(Long id)throws Exception {
        //List<Package> packByPallId = repoPackage.findByPallet_id(id);
        Optional<Pallet> pallet = repoPallet.findById(id);
        if(pallet.isPresent()){
            return pallet.get().getPackegs();
        }else{
            throw new Exception("Pallet not found by id Exception");
        }
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'byPalletId'");
    }

    @Override
    public void update(Package shipment) {
        
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
