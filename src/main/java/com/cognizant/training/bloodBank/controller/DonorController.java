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

import com.cognizant.training.bloodBank.dao.DonorDAO;
import com.cognizant.training.bloodBank.model.Donor;

@RestController
@RequestMapping("/")
public class DonorController {

	@Autowired
	DonorDAO donorDAO;

	/* to save a blood bank */
	@PostMapping("/donor")
	public Donor createDonor(@Valid @RequestBody Donor donor) {
		
		return donorDAO.save(donor);
	}

	/* get all blood banks */
	@GetMapping("/donor")
	public List<Donor> getAllDonors() {
		System.out.println("getAll");
		return donorDAO.findAll();
	}
	
	/* Delete a product */
	@DeleteMapping("/donor/{id}")
	public ResponseEntity<Donor> deleteDonor(@PathVariable(value = "id") Long dId) {

		Optional<Donor> donor = donorDAO.findOne(dId);
		if (donor == null) {
			return ResponseEntity.notFound().build();
		}
		donorDAO.delete(donor.get());

		return ResponseEntity.ok().build();

	}
	
	@PostMapping("/donor/login")
	public boolean login(@Valid @RequestBody Donor donor) {
		return donorDAO.login(donor);
	}
	
	@PutMapping("/donor/")
	public ResponseEntity<Donor> updateDonor(@Valid @RequestBody Donor donor) {

		Optional<Donor> donorOld = donorDAO.findOne(donor.getDonor_id());
		if (donorOld == null) {
			return ResponseEntity.notFound().build();
		}
		donor.setDonor_id(donorOld.get().getDonor_id());
		
		donorDAO.save(donor);
		 return ResponseEntity.ok().build();

	}
}
