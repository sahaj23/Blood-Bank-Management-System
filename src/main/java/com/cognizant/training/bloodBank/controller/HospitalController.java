package com.cognizant.training.bloodBank.controller;

import java.util.List;
import java.util.Optional;

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
import com.cognizant.training.bloodBank.model.BloodBank;
import com.cognizant.training.bloodBank.model.Hospital;

@RestController
@RequestMapping("/")
public class HospitalController {

	@Autowired
	HospitalDAO hospitalDAO;

	/* to save a blood bank */
	@PostMapping("/hospital")
	public Hospital createBloodBank(@Valid @RequestBody Hospital bb) {
		
		return hospitalDAO.save(bb);
	}

	/* get all blood banks */
	@GetMapping("/hospital")
	public List<Hospital> getAllBloodBanks() {
		System.out.println("getAll");
		return hospitalDAO.findAll();
	}
	
	/* Delete a product */
	@DeleteMapping("/hospital/{id}")
	public ResponseEntity<Hospital> deleteBloodBank(@PathVariable(value = "id") Long hospitalId) {

		Optional<Hospital> hospital = hospitalDAO.findOne(hospitalId);
		if (hospital == null) {
			return ResponseEntity.notFound().build();
		}
		hospitalDAO.delete(hospital.get());

		return ResponseEntity.ok().build();

	}
	
	@PostMapping("/hospital/login")
	public boolean login(@Valid @RequestBody Hospital bb) {
		return hospitalDAO.login(bb);
	}
	
	@PutMapping("/hospital/")
	public ResponseEntity<Hospital> updateBloodBank(@Valid @RequestBody Hospital hospital) {

		Optional<Hospital> hospitalOld = hospitalDAO.findOne(hospital.getHospital_id());
		if (hospitalOld == null) {
			return ResponseEntity.notFound().build();
		}
		hospital.setHospital_id(hospitalOld.get().getHospital_id());
		
		hospitalDAO.save(hospital);
		 return ResponseEntity.ok().build();

	}
}
