package com.cognizant.training.bloodBank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.training.bloodBank.dao.HospitalDAO;
import com.cognizant.training.bloodBank.model.Hospital;

@RestController
@RequestMapping("/")
public class HospitalController {

	@Autowired
	HospitalDAO hospitalDAO;

	/* to save a blood bank */
	@PostMapping("/hospital")
	public Hospital createHospital(@Valid @RequestBody Hospital hospital) {
		
		return hospitalDAO.save(hospital);
	}

	/* get all blood banks */
	@GetMapping("/hospital")
	public List<Hospital> getAllHospitals() {
		System.out.println("getAll");
		return hospitalDAO.findAll();
	}
	
	
	@GetMapping("/hospital/{location}")
	public List<Hospital> getHospitalByLocation(@PathVariable(value = "location") String location){
		return hospitalDAO.getHospitalByLocation(location);
	}
	/* Delete a product */
	@DeleteMapping("/hospital/{email}")
	public ResponseEntity<Hospital> deleteHospital(@PathVariable(value = "email") String email) {

		
		hospitalDAO.deleteByEmail(email);

		return ResponseEntity.ok().build();

	}
	
	@PostMapping("/hospital/login")
	public Hospital login(@Valid @RequestBody Hospital bb) {
		return hospitalDAO.login(bb);
	}
	
	@PutMapping("/hospital")
	public ResponseEntity<Hospital> updateHospital(@Valid @RequestBody Hospital hospital) {

		Hospital hospitalOld = hospitalDAO.findOneByEmail(hospital.getEmail());
		if (hospitalOld == null) {
			return ResponseEntity.notFound().build();
		}
		hospital.setHospital_id(hospitalOld.getHospital_id());
		hospital.setPassword(hospitalOld.getPassword());
		hospitalDAO.save(hospital);
		 return ResponseEntity.ok().build();

	}
}
