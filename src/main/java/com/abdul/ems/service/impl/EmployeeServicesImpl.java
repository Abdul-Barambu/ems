package com.abdul.ems.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abdul.ems.entity.Employee;
import com.abdul.ems.repository.EmployeeRepository;
import com.abdul.ems.service.EmployeeServices;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

	// constructor dependancy
	private EmployeeRepository employeeRepository;

	public EmployeeServicesImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(long id) {
		employeeRepository.deleteById(id);
		
	}
	
}
