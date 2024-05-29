package com.example.demo.service;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Customer;
import com.example.demo.repo.RepoCustomer;


@Service
public class CustomerService implements InterfaceService{
    @Autowired
    private RepoCustomer repoCustomer;

    public Customer findById(long id) {
        return repoCustomer.findById(id);
    }
    public void insert(Customer cc) {
        repoCustomer.save(cc);
    }
    @Override
    public void create(Customer costumer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    @Override
    public void update(int id, Customer costumer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    @Override
    public Collection<?> get() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
    
    /* 
    @Override
    public void updateProduct(String id, Product product) {
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
    }
    @Override
    public void deleteProduct(String id) {
        productRepo.remove(id);

    }
    @Override
    public Collection<Product> getProducts() {
        return productRepo.values();
    }*/
}
