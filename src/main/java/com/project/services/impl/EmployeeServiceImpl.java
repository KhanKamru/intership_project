package com.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.Exception.ResourceNotFoundException;
import com.project.entities.Department;
import com.project.entities.Employee;
import com.project.repositories.DepartmentRepo;
import com.project.repositories.EmployeeRepo;
import com.project.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	@Override
	public Employee addEmployee(Employee emp, long d_id) {
		// TODO Auto-generated method stub
		Department dep = departmentRepo.findById(d_id).get();
		emp.setDepartment(dep);
		Employee savedEmp= employeeRepo.save(emp);
		return savedEmp;
	}
	
	@Override
	public List<Employee> getEmployees(String property) {
		// TODO Auto-generated method stub
		return employeeRepo.findAll(Sort.by(Sort.Direction.ASC,property));
	}

	@Override
	public Employee getEmployee(long id) {
		// TODO Auto-generated method stub
		return employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", id));
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepo.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee emp, long id,long d_id) {
		Employee employee=employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", id));
		Department dep =departmentRepo.findById(d_id).get();
		employee.setBirthDate(emp.getBirthDate());
		employee.setCity(emp.getCity());
		employee.setGender(emp.getGender());
		employee.setName(emp.getName());
		employee.setJobTitle(emp.getJobTitle());
		employee.setPhoneNum(emp.getPhoneNum());
		employee.setJobTitle(emp.getJobTitle());
		employee.setDepartment(dep);
		return employeeRepo.save(employee);
	
	}
}
