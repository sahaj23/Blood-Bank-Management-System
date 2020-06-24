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
	
	public void delete(Long hospitalId) {
		hospitalRepository.deleteById(hospitalId);
	}
	
	public int deleteByEmail(String email) {
		return hospitalRepository.deleteByEmail(email);
	}
	
	public List<Hospital> findAll(){
		return hospitalRepository.findAll();
	}
	
	public Optional<Hospital> findOne(Long hospitalid) {
		// return null;
		return hospitalRepository.findById(hospitalid);
	}
	
	public Hospital findOneByEmail(String email) {
		// return null;
		return hospitalRepository.findOneByEmail(email);
	}
	public  Hospital login(Hospital hospital) {
		System.out.println(hospital.getEmail()+" "+hospital.getPassword());
		return hospitalRepository.bloodBankLogin(hospital.getEmail(),hospital.getPassword());
	}
	
	public List<Hospital>  getHospitalByLocation(String location){
		return hospitalRepository.getHospitalByLocation(location);
	}
}
