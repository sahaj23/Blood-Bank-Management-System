package com.cognizant.training.bloodBank.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.training.bloodBank.model.Donor;
import com.cognizant.training.bloodBank.repository.DonorRepository;

@Service
public class DonorDAO {

	@Autowired
	DonorRepository donorRepository;
	public Donor save(Donor donor) {
		return donorRepository.save(donor);
	}
	
	public void delete(Donor donor) {
		donorRepository.delete(donor);
	}
	
	public Donor findOneByEmail(String email) {
		// return null;
		return donorRepository.findOneByEmail(email);
	}
	public List<Donor> findAll(){
		return donorRepository.findAll();
	}
	
	public Optional<Donor> findOne(Long did) {
		// return null;
		return donorRepository.findById(did);
	}
	public  Donor login(Donor donor) {
		return donorRepository.donorLogin(donor.getEmail(),donor.getPassword());
	}
	
	public List<Donor>  getDonorByLocation(String location){
		return donorRepository.getDonorByLocation(location);
	}
}
