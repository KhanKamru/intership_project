package com.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Exception.ResourceNotFoundException;
import com.project.entities.Department;
import com.project.repositories.DepartmentRepo;
import com.project.services.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepo deptRepo;
	
	@Override
	public Department addDepartment(Department department) {
		return deptRepo.save(department);
	}
	@Override
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return deptRepo.findAll();
	}

	@Override
	public Department getDepartment(long id) {
		// TODO Auto-generated method stub
		return deptRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department", id));
	}

	@Override
	public void deleteDepartment(long id) {
		deptRepo.deleteById(id);
	}

	@Override
	public Department updateDepartment(Department dep, long id) {
		Department department=deptRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department", id));;
		department.setDepartmentHead(dep.getDepartmentHead());
		department.setDepartmentName(dep.getDepartmentName());
		return deptRepo.save(department);

	}

}
