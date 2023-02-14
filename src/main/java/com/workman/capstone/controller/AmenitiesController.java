package com.workman.capstone.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.workman.capstone.model.Amenities;
import com.workman.capstone.model.Testimonial;
import com.workman.capstone.service.AmenitiesService;
import com.workman.capstone.service.TestimonialService;

@Controller
public class AmenitiesController {
	
	@Autowired
	AmenitiesService amenitiesService;
	
	@Autowired
	TestimonialService testimonialService;
	
	@RequestMapping("/amenity/update/{id}")
	public ModelAndView updateAmenity(@PathVariable("id") Long id, Model model) {
		ModelAndView view = new ModelAndView("amenitiesform");
		Amenities amentityObj = amenitiesService.getAmenityById(id);
		if(amentityObj == null) {
			throw new RuntimeException("Employee with id" + id + "is not found");
		}
		model.addAttribute("title","Update Amenity");
		view.addObject("amenity", amentityObj);
		return view;
	}
	
	@RequestMapping("/amenity/add")
	public ModelAndView add(Amenities amenity, Model model) {
		ModelAndView view = new ModelAndView("amenitiesform");
		view.addObject("amenity", new Amenities());
		model.addAttribute("title", "Add Amenity");
		return view;
	}
	
	@RequestMapping("/amenity/save")
	public ModelAndView save(Amenities amenity) {
		ModelAndView view = new ModelAndView("admin-dashboard");
		if(amenity.getId() != null) {
			amenitiesService.updateAmenity(amenity.getId(), amenity);
		}else {
			amenitiesService.addAmenity(amenity);
		}
		view.addObject("amenitiesList", amenitiesService.getAllAmenities());
		view.addObject("testimonialList", testimonialService.getAllTestimonials());
		return view;
	}
	
	@RequestMapping("/amenity/delete/{id}")
	public ModelAndView deleteAmenity(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("admin-dashboard");
		amenitiesService.deleteAmenity(id);
		view.addObject("amenitiesList", amenitiesService.getAllAmenities());
		view.addObject("testimonialList", testimonialService.getAllTestimonials());
		return view;
	}
	

}

