package com.project.services;

import java.util.List;

import com.project.entities.Department;

public interface DepartmentService {
	Department addDepartment(Department department);
	List<Department> getDepartments();
	Department getDepartment(long id);
	void deleteDepartment(long id);
	Department updateDepartment(Department dep,long id);

}
