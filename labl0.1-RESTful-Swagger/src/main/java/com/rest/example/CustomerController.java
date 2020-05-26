package com.rest.example;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CustomerController {

	@Autowired
	private CustomerBeanService  service;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers()
	{
		return service.findAll();
	}
	
	
@GetMapping("/customers/{name}")
public Customer  getCustomer(@PathVariable  String name)
{
  return service.findCustomer(name);
  
}

//http response status comes as 200
@PostMapping("customers")
public void createCustomer(@RequestBody Customer customer)
{
	Customer cust = service.saveCustomer(customer);
}

// check the staus - it is 201
// check the headers -> Location 
@PostMapping("customersWithStatus")
public ResponseEntity<Object> createCustomerWithSatus(@RequestBody Customer customer)
{
	Customer savedCustomer = service.saveCustomer(customer);
	
	URI   uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}").
            buildAndExpand(savedCustomer.getName()).toUri();

    return ResponseEntity.created(uri).build();

}

}
