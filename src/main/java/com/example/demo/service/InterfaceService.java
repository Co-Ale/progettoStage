package com.example.demo.service;

import com.example.demo.entity.Customer;
import java.util.Collection;

public interface InterfaceService {

    public abstract void create(Customer costumer);
    public abstract void update(int id, Customer costumer);
    public abstract void delete(int id);
    public abstract Collection<?> get();
}
