package com.springboot.hateoas.service;

import java.util.List;
import java.util.Optional;

import com.springboot.hateoas.model.Employee;

public interface Employeeserv {

	public Optional<Employee> getEmployeeByIdFromService(int eid);
	
	public List<Employee> getAllEmployeesFromService();
}