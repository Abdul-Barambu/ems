package com.abdul.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abdul.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
