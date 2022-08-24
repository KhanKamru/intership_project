package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.Employee;
import com.project.services.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp,@RequestParam("deptId") long d_id)
	{
		return new ResponseEntity<>(employeeService.addEmployee(emp, d_id),HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam(value="sort",defaultValue = "name", required = false) String property)
	{
		return new ResponseEntity<>(employeeService.getEmployees(property),HttpStatus.OK);
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable long id)
	{
		return new ResponseEntity<>(employeeService.getEmployee(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable long id)
	{
		employeeService.deleteEmployee(id);
	}
	
	@PutMapping("/{id}")
	public void updateEmployee(@RequestBody Employee emp,@PathVariable long id,@RequestParam("dept_id") long d_id)
	{
		employeeService.updateEmployee(emp,id,d_id);
	}
}
