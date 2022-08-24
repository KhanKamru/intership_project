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

import com.project.entities.Professer;
import com.project.services.ProfesserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/professer")
public class ProfesserController {

	@Autowired
	private ProfesserService professerSrevice;

	@GetMapping("/{id}")
	public ResponseEntity<Professer> getProfesser(@PathVariable int id) {
		return new ResponseEntity<>(professerSrevice.getProfesser(id), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<Professer>> getProfessers() {
		return new ResponseEntity<>(professerSrevice.getProfessers(), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Professer> addProfesser(@RequestBody Professer professer,@RequestParam(value="dept_id") long[] dept_ids) {
		return new ResponseEntity<>(professerSrevice.addProfesser(professer, dept_ids),HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public String deleteDepartment(@PathVariable int id) {
		professerSrevice.deleteProfesser(id);
		return "home";
	}

	@PutMapping("/{id}")
	public ResponseEntity<Professer> upadateDepartment(@RequestBody Professer professer, @PathVariable int id) {
		return new ResponseEntity<>(professerSrevice.updateProfesser(professer, id), HttpStatus.OK);
	}

}
