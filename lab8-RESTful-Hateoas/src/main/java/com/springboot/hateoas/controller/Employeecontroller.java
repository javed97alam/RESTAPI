package com.springboot.hateoas.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hateoas.model.Employee;
import com.springboot.hateoas.service.Employeeserv;
import com.springboot.hateoas.util.Helper;

@RestController
@RequestMapping(value= "/employee")
public class Employeecontroller {

	@Autowired
	Employeeserv eserv;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// Fetch employee details on the basis of employee id.
	@GetMapping(value= "/get/{id}")
	public EntityModel<Employee> getEmployeeById(@PathVariable(name= "id") int eid) {
		logger.info("employee byId() invoked= " + eid);

		// Fetching employee details from the mocked service.
		Employee emp= eserv.getEmployeeByIdFromService(eid).get();
		logger.info("employee byId() found= " + emp.toString());

		// Creating links as per the hateoas principle.
		EntityModel<Employee> empres= new EntityModel<Employee>(emp);
		empres.add(linkTo(methodOn(Employeecontroller.class).getEmployeeById(eid)).withRel("_self"));
		return empres;
	}

	// Fetch all employees.
	@GetMapping(value= "/getall")
	public List<EntityModel<Employee>> getAllEmployees() {
		logger.info("employees all() invoked");

		// Fetching employees from the mocked service.
		List<Employee> employees = eserv.getAllEmployeesFromService();
		List<EntityModel<Employee>> empreslist= new ArrayList<EntityModel<Employee>>();

		// Creating links as per the hateoas principle.
		for (Employee employee : employees) {
			empreslist.add(Helper.getEmployeeResource(employee));
		}

		logger.info("employees all() found: " + empreslist.size());
		return empreslist;
	}
}