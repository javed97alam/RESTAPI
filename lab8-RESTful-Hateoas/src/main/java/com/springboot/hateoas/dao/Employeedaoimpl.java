package com.springboot.hateoas.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;
import com.springboot.hateoas.model.Employee;

@Repository
public class Employeedaoimpl implements Employeedao {

	// Employee list.
	static List<Employee> employees;

	static {
		employees = new ArrayList<Employee>();
		// To generate the dummy identity for the employees.
		Faker faker = new Faker();
		// Creating dummy employees.
		for(int i=1; i<=10; i++) {
			Employee emp = new Employee();
			emp.setId(i);
			emp.setName(faker.name().fullName());
			emp.setMobile(faker.phoneNumber().cellPhone());
			emp.setAddress(faker.address().fullAddress());
			// Adding the employee records to the list.
			employees.add(emp);
		}
	}

	// Returning mocked employee details on the basis of employee id.
	@Override
	public Optional<Employee> getEmployeeByIdFromDb(int eid) {
		return employees.stream().filter((employee) -> employee.getId() == eid).findFirst();
	}

	// Returning mocked employee list.
	@Override
	public List<Employee> getAllEmployeesFromDb() {
		return employees;
	}
}