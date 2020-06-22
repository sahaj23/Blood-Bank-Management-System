package com.cognizant.training.bloodBank.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.training.bloodBank.model.Hospital;
import com.cognizant.training.bloodBank.repository.HospitalRepository;

@Service
public class HospitalDAO {
	@Autowired
	HospitalRepository hospitalRepository;
	public Hospital save(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}
	
	public void delete(Hospital hospital) {
		hospitalRepository.delete(hospital);
	}
	
	public List<Hospital> findAll(){
		return hospitalRepository.findAll();
	}
	
	public Optional<Hospital> findOne(Long hospitalid) {
		// return null;
		return hospitalRepository.findById(hospitalid);
	}
	public  boolean login(Hospital hospital) {
		return hospitalRepository.bloodBankLogin(hospital.getEmail(),hospital.getPassword())==null?false:true;
	}
}
