package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.demo.entity.Customer;

import com.example.demo.repo.RepoCustomer;
import com.example.demo.repo.RepoShipment;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ShipmentService;


@SpringBootTest
class DemoApplicationTestsCustomer {
	@Autowired
    CustomerService customerService;
	@Autowired
	RepoCustomer repoCustomer ;
	@Autowired
	RepoShipment repoShipment;
	@Autowired
	ShipmentService shipmentService;
	

	/*@Test
	void contextLoads() {

	}*/

	@Test
	//@DisplayName("\ncustomer test")
	public void createTest() throws Exception{
		repoCustomer.deleteAll();
		Customer c = new Customer (null, "ale","case mia");
		customerService.create(c);
		assertEquals(c.getId(), customerService.getById(c.getId()).getId());
	}

	@Test
	public void getAllTest() throws Exception{
		repoCustomer.deleteAll();
		Customer c = new Customer (null, "ale","case mia");
		customerService.create(c);
		assertNotNull(customerService.getAll());
	}
	@Test
	public void getByIdest() throws Exception{
		repoCustomer.deleteAll();
		Customer c = new Customer (null, "ale","case mia");
		customerService.create(c);
		assertNotNull(customerService.getById(c.getId()));
	}



}
