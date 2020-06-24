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

import com.cognizant.training.bloodBank.dao.BloodDetailsDAO;
import com.cognizant.training.bloodBank.model.BloodDetails;

@RestController
@RequestMapping("/")
public class BloodDetailsController {

	@Autowired
	BloodDetailsDAO bloodDetailsDAO;

	/* to save a blood bank */
	@PostMapping("/blood-details")
	public BloodDetails createBloodDetails(@Valid @RequestBody BloodDetails bd) {
		
		return bloodDetailsDAO.save(bd);
	}

	@GetMapping("/blood-details/{location}")
	public List<BloodDetails> getBloodBankByLocation(@PathVariable(value = "location") String location){
		return bloodDetailsDAO.getBloodBankByLocation(location);
	}
	/* get all blood banks */
	@GetMapping("/blood-details")
	public List<BloodDetails> getAllBloodDetails() {
		System.out.println("getAll");
		return bloodDetailsDAO.findAll();
	}
	
	/* Delete a product */
	@DeleteMapping("/blood-details/{id}")
	public ResponseEntity<BloodDetails> deleteBloodDetails(@PathVariable(value = "id") Long bdId) {

		Optional<BloodDetails> bd = bloodDetailsDAO.findOne(bdId);
		if (bd == null) {
			return ResponseEntity.notFound().build();
		}
		bloodDetailsDAO.delete(bd.get());

		return ResponseEntity.ok().build();

	}
	
	@PutMapping("/blood-details/")
	public ResponseEntity<BloodDetails> updateBloodDetails(@Valid @RequestBody BloodDetails bd) {

		Optional<BloodDetails> bdOld = bloodDetailsDAO.findOne(bd.getBlood_id());
		if (bdOld == null) {
			return ResponseEntity.notFound().build();
		}
		bd.setBlood_id(bdOld.get().getBlood_id());
		
		bloodDetailsDAO.save(bd);
		 return ResponseEntity.ok().build();

	}
}
