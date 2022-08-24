package com.project.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Exception.ResourceNotFoundException;
import com.project.entities.Department;
import com.project.entities.Professer;
import com.project.repositories.DepartmentRepo;
import com.project.repositories.ProfesserRepo;
import com.project.services.ProfesserService;

@Service
public class ProfesserServiceImpl implements ProfesserService{

	@Autowired
	private ProfesserRepo professerRepo;
	
	@Autowired
	private DepartmentRepo deptRepo;
	
	@Override
	public List<Professer> getProfessers() {
		// TODO Auto-generated method stub
		return professerRepo.findAll();
	}
	
	@Override
	public Professer getProfesser(long id) {
		return professerRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Professer", id));
	}

	@Override
	public void deleteProfesser(long id) {
		professerRepo.deleteById(id);
	}

	@Override
	public Professer updateProfesser(Professer professer, long id) {
		Professer oldProfesser=professerRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Professer", id));
		oldProfesser.setBirthDate(professer.getBirthDate());
		oldProfesser.setName(professer.getName());
		oldProfesser.setGender(professer.getGender());
		oldProfesser.setPhoneNumber(professer.getPhoneNumber());
		oldProfesser.setSubject(professer.getSubject());
		return professerRepo.save(oldProfesser);
	}

	@Override
	public Professer addProfesser(Professer professer,long[] dept_ids) {
		Set<Department> departments=new HashSet<>();
		for(int i=0;i<dept_ids.length;i++)
		{
			Department department=deptRepo.findById(dept_ids[i]).get();
			departments.add(department);
		}
		professer.setDepartments(departments);
		return professerRepo.save(professer);
	}

}
