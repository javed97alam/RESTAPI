package com.springboot.hateoas.dao;

import java.util.List;
import java.util.Optional;

import com.springboot.hateoas.model.Employee;

public interface Employeedao {

	public Optional<Employee> getEmployeeByIdFromDb(int eid);

	public List<Employee> getAllEmployeesFromDb();
}