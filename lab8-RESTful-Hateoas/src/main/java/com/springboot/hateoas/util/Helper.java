package com.springboot.hateoas.util;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;

import com.springboot.hateoas.controller.Employeecontroller;
import com.springboot.hateoas.model.Employee;

public class Helper {

	// Utility method to prepare the self link.
	public static EntityModel<Employee> getEmployeeResource(Employee employee) {
		EntityModel<Employee> resource = new EntityModel<Employee>(employee);
		resource.add(linkTo(methodOn(Employeecontroller.class).getEmployeeById(employee.getId())).withRel("_self"));
		return resource;
	}
}