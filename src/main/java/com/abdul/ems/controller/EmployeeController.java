package com.abdul.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.abdul.ems.entity.Employee;
import com.abdul.ems.service.EmployeeServices;

@Controller
public class EmployeeController {

	// constructor dependancy
	
	private EmployeeServices employeeServices;

	public EmployeeController(EmployeeServices employeeServices) {
		super();
		this.employeeServices = employeeServices;
	}
	
	@GetMapping("/employee")
	public String getAllEmployee(Model model) {
		model.addAttribute("employee", employeeServices.getAllEmployees());
		return "Employee";
		
	}
	
	// handle add button
	@GetMapping("/addEmployeeButton")
	public String addNewEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "createNewEmployee";
		
	}
	
	// handle save form button
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeServices.saveEmployee(employee);
		return "redirect:/employee";
		
	}	
	
	// handle update button
	@GetMapping("/editEmployee/{id}")
	public String getEmployeeById(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeServices.getEmployeeById(id));
		return "updateEmployee";
		
	}
	
	// handle the UpdateSave button
	@PostMapping("/updateEmployee/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model) {
		
		//get user from database
		//create object of Employee class
		Employee existingEmployee = new Employee();
		
		existingEmployee.setId(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setPhone(employee.getPhone());
		
	    employeeServices.updateEmployee(existingEmployee);
	    
		return "redirect:/employee";
		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeServices.deleteEmployeeById(id);
		return "redirect:/employee";
		
	}
	
	
	
	
	
	
	
	
}
