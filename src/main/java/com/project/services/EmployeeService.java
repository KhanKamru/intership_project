package com.project.services;

import java.util.List;

import com.project.entities.Employee;


public interface EmployeeService {

	Employee addEmployee(Employee emp,long d_id); 
	List<Employee> getEmployees(String property);
	Employee getEmployee(long id);
	void deleteEmployee(long id);
	Employee updateEmployee(Employee emp,long id,long d_id);
}
