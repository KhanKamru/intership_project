package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
