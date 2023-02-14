package com.workman.capstone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.workman.capstone.model.Testimonial;
import com.workman.capstone.repository.TestimonialRepository;

@Service
public class TestimonialService {
	
	
	TestimonialRepository testimonialRepo;
	
	public TestimonialService(TestimonialRepository testimonialRepo) {
		this.testimonialRepo = testimonialRepo;
	}

	public TestimonialRepository getTestimonialRepo() {
		return testimonialRepo;
	}

	public void setTestimonialRepo(TestimonialRepository testimonialRepo) {
		this.testimonialRepo = testimonialRepo;
	}

	public List<Testimonial> getAllTestimonials(){
		List<Testimonial> testimonialList = new ArrayList<Testimonial>();
		testimonialRepo.findAll().forEach(testimonialList::add);
		return testimonialList;
	}
	
	public void addTestimonial(Testimonial newTestimonial) {
		 testimonialRepo.save(newTestimonial);
	}
	
	public void updateTestimonial(Long id, Testimonial testimonial) {
		Optional<Testimonial> testimonialData = testimonialRepo.findById(id);
		if(testimonialData.isPresent()) {
			Testimonial _testimonial = testimonialData.get();
			_testimonial.setTitle(testimonial.getTitle());
			_testimonial.setMessage(testimonial.getMessage());
			testimonialRepo.save(_testimonial);
		}
	}
	
	public void deleteTestimonial(Long id) {
		testimonialRepo.deleteById(id);
	}
	
}
