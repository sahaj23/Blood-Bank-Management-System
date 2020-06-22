package com.cognizant.training.bloodBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.training.bloodBank.model.BloodBank;
import com.cognizant.training.bloodBank.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
	
	@Query(value = "SELECT * FROM hospital WHERE email = :email and password= :password", nativeQuery = true)
	BloodBank bloodBankLogin(String email,String password);
}
