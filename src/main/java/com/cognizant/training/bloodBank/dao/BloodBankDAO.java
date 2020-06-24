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
	
	public int deleteByEmail(String email) {
		return bloodBankRepository.deleteByEmail(email);
	}
	public List<BloodBank> findAll(){
		return bloodBankRepository.findAll();
	}
	
	public BloodBank findOneByEmail(String email) {
		// return null;
		return bloodBankRepository.findOneByEmail(email);
	}
	public Optional<BloodBank> findOne(Long bbid) {
		// return null;
		return bloodBankRepository.findById(bbid);
	}
	public  BloodBank login(BloodBank bb) {
		return bloodBankRepository.bloodBankLogin(bb.getEmail(),bb.getPassword());
	}
	
	public List<BloodBank>  getBloodBankByLocation(String location){
		System.out.println(location);
		return bloodBankRepository.getBloodBankByLocation(location);
	}
}
