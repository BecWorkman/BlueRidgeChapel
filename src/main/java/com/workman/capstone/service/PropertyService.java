package com.workman.capstone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workman.capstone.model.Property;
import com.workman.capstone.repository.PropertyRepository;

@Service
public class PropertyService {
	
	PropertyRepository propertyRepo;
	
	public PropertyService(PropertyRepository propertyRepo) {
		this.propertyRepo = propertyRepo;
	}

	public PropertyRepository getPropertyRepo() {
		return propertyRepo;
	}

	public void setPropertyRepo(PropertyRepository propertyRepo) {
		this.propertyRepo = propertyRepo;
	}
	
	public List<Property> getAllProperties(){
		List<Property> propertyList = new ArrayList<Property>();
		propertyRepo.findAll().forEach(propertyList::add);
		return propertyList;
	}
	
	public void addProperty(Property newproperty) {
		propertyRepo.save(newproperty);
	} 
	
	public void deleteProperty(Long id) {
		propertyRepo.deleteById(id);
	}
	
	public void updateTextBook(Long id, Property property) {
		Optional<Property> propertyData = propertyRepo.findById(id);
		if(propertyData.isPresent()) {
			Property _property = propertyData.get();
			_property.setName(property.getName());
			_property.setAddress(property.getAddress());
			propertyRepo.save(_property);
		}
	}
	

}
