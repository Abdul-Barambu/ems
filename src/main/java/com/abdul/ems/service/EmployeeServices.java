package com.abdul.ems.service;

import java.util.List;

import com.abdul.ems.entity.Employee;

public interface EmployeeServices {

	List<Employee> getAllEmployees();
	
	Employee saveEmployee(Employee employee);
	
	Employee getEmployeeById(Long id);
	Employee updateEmployee(Employee employee);
	
	void deleteEmployeeById(long id);
	
}
