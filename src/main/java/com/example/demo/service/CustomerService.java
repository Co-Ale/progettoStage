package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Customer;
import com.example.demo.repo.RepoCustomer;


@Service
public class CustomerService implements InterfaceCustomerService{
    @Autowired
    private RepoCustomer repoCustomer;

    
    @Override
    public void create(Customer customer) {
      
        repoCustomer.save(customer);
    }
    @Override
    public void update(Long id, Customer costumer) {
       
        repoCustomer.save(costumer);
      
    }
    @Override
    public void delete(Long id) {
        repoCustomer.deleteById(id);
    }
    @Override
    public Customer getById(Long id) throws Exception {
        Optional<Customer> opId  = repoCustomer.findById(id);
        if (opId.isPresent() ){
            return opId.get();
        }else{
            throw new Exception("Customer Not foun Exeption");
        }
    }
    
    @Override
    public Iterable<Customer> getAll() throws Exception {
        List<Customer> allC = repoCustomer.findAll();
        if(!allC.isEmpty()){
            return allC;
        }else{
            throw new Exception("empty consumer database");
        }
    }
    
    /* 
    public Customer findById(long id) {
        return repoCustomer.findById(id);
    }
    public void insert(Customer cc) {
        repoCustomer.save(cc);
    }




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
