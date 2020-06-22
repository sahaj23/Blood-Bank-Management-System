package com.cognizant.training.bloodBank.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.training.bloodBank.model.Seeker;
import com.cognizant.training.bloodBank.repository.SeekerRepository;

@Service
public class SeekerDAO {

	@Autowired
	SeekerRepository seekerRepository;
	public Seeker save(Seeker seeker) {
		return seekerRepository.save(seeker);
	}
	
	public void delete(Seeker seeker) {
		seekerRepository.delete(seeker);
	}
	
	public List<Seeker> findAll(){
		return seekerRepository.findAll();
	}
	
	public Optional<Seeker> findOne(Long sid) {
		// return null;
		return seekerRepository.findById(sid);
	}
	public  boolean login(Seeker seeker) {
		return seekerRepository.seekerLogin(seeker.getEmail(),seeker.getPassword())==null?false:true;
	}
}
