package com.example.demo.service;



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
    public void update(long id, Customer costumer) {
       
        repoCustomer.save(costumer);
      
    }
    @Override
    public void delete(long id) {
        repoCustomer.deleteById(id);
    }
    @Override
    public Customer findById(long id) {
        return repoCustomer.findById(id);
    }
    @Override
    public Iterable<Customer> getAll() {

        return repoCustomer.findAll();
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
