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

import com.cognizant.training.bloodBank.dao.BloodBankDAO;
import com.cognizant.training.bloodBank.model.BloodBank;

@RestController
@RequestMapping("/")
public class BloodBankController {
	
	@Autowired
	BloodBankDAO bloodBankDAO;

	/* to save a blood bank */
	@PostMapping("/blood-bank")
	public BloodBank createBloodBank(@Valid @RequestBody BloodBank bb) {
		
		return bloodBankDAO.save(bb);
	}

	/* get all blood banks */
	@GetMapping("/blood-bank")
	public List<BloodBank> getAllBloodBanks() {
		System.out.println("getAll");
		return bloodBankDAO.findAll();
	}
	
	/* Delete a product */
	@DeleteMapping("/blood-bank/{id}")
	public ResponseEntity<BloodBank> deleteBloodBank(@PathVariable(value = "id") Long bbId) {

		Optional<BloodBank> bb = bloodBankDAO.findOne(bbId);
		if (bb == null) {
			return ResponseEntity.notFound().build();
		}
		bloodBankDAO.delete(bb.get());

		return ResponseEntity.ok().build();

	}
	
	@PostMapping("/blood-bank/login")
	public boolean login(@Valid @RequestBody BloodBank bb) {
		return bloodBankDAO.login(bb);
	}
	
	@PutMapping("/blood-bank/")
	public ResponseEntity<BloodBank> updateBloodBank(@Valid @RequestBody BloodBank bb) {

		Optional<BloodBank> bbOld = bloodBankDAO.findOne(bb.getBlood_bank_id());
		if (bbOld == null) {
			return ResponseEntity.notFound().build();
		}
		bb.setBlood_bank_id(bbOld.get().getBlood_bank_id());
		
		 bloodBankDAO.save(bb);
		 return ResponseEntity.ok().build();

	}
	
	
}
