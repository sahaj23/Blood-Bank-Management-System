package com.cognizant.training.bloodBank.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.training.bloodBank.model.BloodDetails;
import com.cognizant.training.bloodBank.repository.BloodDetailsRepository;

@Service
public class BloodDetailsDAO {

	@Autowired
	BloodDetailsRepository bloodDetailsRepository;
	public BloodDetails save(BloodDetails bd) {
		return bloodDetailsRepository.save(bd);
	}
	
	public void delete(BloodDetails bd) {
		bloodDetailsRepository.delete(bd);
	}
	
	public List<BloodDetails> findAll(){
		return bloodDetailsRepository.findAll();
	}
	
	public Optional<BloodDetails> findOne(Long bdid) {
		// return null;
		return bloodDetailsRepository.findById(bdid);
	}
}
