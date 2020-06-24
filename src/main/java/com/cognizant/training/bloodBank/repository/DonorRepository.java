package com.cognizant.training.bloodBank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.training.bloodBank.model.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long>{

	@Query(value = "SELECT * FROM donor WHERE email = :email and password= :password", nativeQuery = true)
	Donor donorLogin(String email,String password);
	
	@Query(value = "SELECT * FROM donor WHERE location = :location", nativeQuery = true)
	List<Donor> getDonorByLocation(String location);
	
	@Query(value = "SELECT *  FROM donor WHERE email = :email", nativeQuery = true)
	Donor findOneByEmail(String email);
	
}
