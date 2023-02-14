package com.workman.capstone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workman.capstone.model.Amenities;
import com.workman.capstone.model.Testimonial;
import com.workman.capstone.repository.AmenitiesRepository;

@Service
public class AmenitiesService {
	
	
	AmenitiesRepository amenitiesRepo;
	
	
	public AmenitiesService(AmenitiesRepository amenitiesRepo) {
		this.amenitiesRepo = amenitiesRepo;
	}

	public AmenitiesRepository getAmenitiesRepo() {
		return amenitiesRepo;
	}

	public void setAmenitiesRepo(AmenitiesRepository amenitiesRepo) {
		this.amenitiesRepo = amenitiesRepo;
	}
	
	public List<Amenities> getAllAmenities(){
		List<Amenities> amenitiesList = new ArrayList<Amenities>();
		amenitiesRepo.findAll().forEach(amenitiesList::add);
		return amenitiesList;
	}
	
	public Amenities getAmenityById(Long id){
		return amenitiesRepo.getById(id);
	}
	
	public void addAmenity(Amenities newAmenity) {
		amenitiesRepo.save(newAmenity);
	}
	
	public void updateAmenity(Long id, Amenities amenity) {
		Optional<Amenities> amenityData = amenitiesRepo.findById(id);
		if(amenityData.isPresent()) {
			Amenities _amenity = amenityData.get();
			_amenity.setName(amenity.getName());
			_amenity.setDescription(amenity.getDescription());
			_amenity.setPropertyLocation(amenity.getPropertyLocation());
			amenitiesRepo.save(amenity);
		}
	}
	
	public void deleteAmenity(Long id) {
		amenitiesRepo.deleteById(id);
	}

}
