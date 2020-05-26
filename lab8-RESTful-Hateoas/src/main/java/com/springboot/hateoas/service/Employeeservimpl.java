package com.springboot.hateoas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.hateoas.dao.Employeedao;
import com.springboot.hateoas.model.Employee;

@Service
public class Employeeservimpl implements Employeeserv {

	@Autowired
	Employeedao edao;

	// Service method to fetch employee details from the repository.
	@Override
	public Optional<Employee> getEmployeeByIdFromService(int eid) {
		return edao.getEmployeeByIdFromDb(eid);
	}

	// Service method to fetch the employee list.
	@Override
	public List<Employee> getAllEmployeesFromService() {
		return edao.getAllEmployeesFromDb();
	}
}