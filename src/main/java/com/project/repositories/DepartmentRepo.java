package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long>{

}
