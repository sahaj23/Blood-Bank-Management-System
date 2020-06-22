package com.cognizant.training.bloodBank.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.training.bloodBank.model.BloodBank;
import com.cognizant.training.bloodBank.repository.BloodBankRepository;

@Service
public class BloodBankDAO {
	
	@Autowired
	BloodBankRepository bloodBankRepository;
	public BloodBank save(BloodBank bb) {
		return bloodBankRepository.save(bb);
	}
	
	public void delete(BloodBank bb) {
		bloodBankRepository.delete(bb);
	}
	
	public List<BloodBank> findAll(){
		return bloodBankRepository.findAll();
	}
	
	public Optional<BloodBank> findOne(Long bbid) {
		// return null;
		return bloodBankRepository.findById(bbid);
	}
	public  boolean login(BloodBank bb) {
		return bloodBankRepository.bloodBankLogin(bb.getEmail(),bb.getPassword())==null?false:true;
	}
}
