package com.example.demo;

import com.example.demo.utility.ShipmentState;
import com.example.utility.GetEntityForTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;




import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Shipment;
import com.example.demo.repo.RepoCustomer;
import com.example.demo.repo.RepoShipment;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ShipmentService;

@SpringBootTest
class DemoApplicationTestsShipment {
	@Autowired
    ShipmentService shipmentService;
	@Autowired
    CustomerService customerService;
	
	@Autowired
	RepoShipment repoShipment ;
	@Autowired
	RepoCustomer repoCustomer ;
	
	
	
	/*@Test
	void contextLoads() {

	}*/

	@Test
	//@DisplayName("\ncustomer test")
	public void createTest() throws Exception{

		Customer c = GetEntityForTest.crateCustomer();
		repoCustomer.deleteAll();;
		customerService.create(c);
		Shipment s = new Shipment ();
		repoShipment.delete(s);
		s.setDescription("ciao");
		s.setStatus(ShipmentState.OPEN);		
		shipmentService.create(c.getId(), s);
		
		repoCustomer.delete(c);
		repoShipment.delete(s);
	}
	


	@Test
	public void getTest() throws Exception{
		Customer c = GetEntityForTest.crateCustomer();
		repoCustomer.deleteAll();;
		customerService.create(c);
		Shipment s = new Shipment ();
		repoShipment.delete(s);
		s.setDescription("ciao");
		s.setStatus(ShipmentState.OPEN);		
		shipmentService.create(c.getId(), s);

		
		assertNotNull(shipmentService.getById(s.getId()));
		repoCustomer.delete(c);
		repoShipment.delete(s);
	

	}
	
	@Test
	public void getAllTest() throws Exception{
		Customer c = GetEntityForTest.crateCustomer();
		repoCustomer.deleteAll();
		customerService.create(c);
		Shipment s = new Shipment ();
		repoShipment.delete(s);
		shipmentService.create(c.getId(), s);

		assertNotNull(shipmentService.getAll());
		repoCustomer.delete(c);
		repoShipment.delete(s);

	}
	@Test
	public void getAllOpenTest() throws Exception{
		Customer c = GetEntityForTest.crateCustomer();
		repoCustomer.deleteAll();
		customerService.create(c);
		Shipment s = new Shipment ();
		repoShipment.delete(s);
		shipmentService.create(c.getId(), s);

		assertNotNull(shipmentService.getAllOpen());
		
		repoCustomer.delete(c);
		repoShipment.delete(s);
		
	}
	@Test
	public void getByClientIdTest() throws Exception{
		Customer c = GetEntityForTest.crateCustomer();
		repoCustomer.deleteAll();
		customerService.create(c);
		Shipment s = new Shipment ();
		repoShipment.delete(s);
		shipmentService.create(c.getId(), s);

		assertNotNull(shipmentService.getByClientId(c.getId()));

		repoCustomer.delete(c);
		repoShipment.delete(s);
	}
	
}