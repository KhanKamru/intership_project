package com.project.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="d_name",nullable = false,length = 50)
	private String departmentName;
	
	@Column(name="d_head",length =50)
	private String departmentHead;
	
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	private List<Employee> employees=new ArrayList<>();

	@ManyToMany(mappedBy = "departments",cascade = CascadeType.ALL)
	private List<Professer> professers=new ArrayList<>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Professer> getProfessers() {
		return professers;
	}

	public void setProfessers(List<Professer> professers) {
		this.professers = professers;
	}	

}
