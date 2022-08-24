package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.Department;
import com.project.services.DepartmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/{id}")
	public ResponseEntity<Department> addForm(@PathVariable long id) {
		return new ResponseEntity<>(departmentService.getDepartment(id), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<Department>> addForm() {
		return new ResponseEntity<>(departmentService.getDepartments(), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		return new ResponseEntity<Department>(departmentService.addDepartment(department), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public String deleteDepartment(@PathVariable int id) {
		departmentService.deleteDepartment(id);
		return "home";
	}

	@PutMapping("/{id}")
	public ResponseEntity<Department> upadateDepartment(@RequestBody Department department, @PathVariable long id) {
		return new ResponseEntity<Department>(departmentService.updateDepartment(department, id), HttpStatus.OK);
	}
}