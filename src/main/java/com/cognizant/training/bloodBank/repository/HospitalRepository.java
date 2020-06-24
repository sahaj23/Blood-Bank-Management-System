package com.cognizant.training.bloodBank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.training.bloodBank.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
	
	@Query(value = "SELECT * FROM hospital WHERE email = :email and password= :password", nativeQuery = true)
	Hospital bloodBankLogin(String email,String password);
	
	@Query(value = "SELECT * FROM hospital WHERE location = :location", nativeQuery = true)
	List<Hospital> getHospitalByLocation(String location);
	
	@Modifying
    @Transactional
	@Query(value = "DELETE  FROM hospital WHERE email = :email", nativeQuery = true)
	int deleteByEmail(String email);
	
	@Query(value = "SELECT *  FROM hospital WHERE email = :email", nativeQuery = true)
	Hospital findOneByEmail(String email);
}
