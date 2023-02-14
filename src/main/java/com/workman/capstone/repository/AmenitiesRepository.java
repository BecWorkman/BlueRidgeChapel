package com.workman.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workman.capstone.model.Amenities;

@Repository
public interface AmenitiesRepository extends JpaRepository<Amenities, Long>{
	
	public Amenities getById(Long id);
	

}
