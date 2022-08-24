package com.project.services;

import java.util.List;

import com.project.entities.Professer;

public interface ProfesserService {

	Professer addProfesser(Professer professer,long[] dept_id);
	List<Professer> getProfessers();
	Professer getProfesser(long id);
	void deleteProfesser(long id);
	Professer updateProfesser(Professer professer,long id);
}
