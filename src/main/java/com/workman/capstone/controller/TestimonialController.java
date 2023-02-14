package com.workman.capstone.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.workman.capstone.model.Testimonial;
import com.workman.capstone.service.AmenitiesService;
import com.workman.capstone.service.TestimonialService;

@Controller
public class TestimonialController {
		
	@Autowired
	private TestimonialService testimonialService;
	
	@Autowired
	AmenitiesService amenitiesService;
	
	@GetMapping("/testimonials")
	public ModelAndView getAllTestimonials() {
		ModelAndView list = new ModelAndView("testimonials");
		list.addObject("testimonialList", testimonialService.getAllTestimonials());
		return list;
	}
	
	@RequestMapping("/testimonials/add")
	public ModelAndView createTestimonial(Testimonial testimonial) {
		ModelAndView newTestimonial = new ModelAndView("testimonials");
		testimonialService.addTestimonial(testimonial);
		newTestimonial.addObject("testimonialList", testimonialService.getAllTestimonials());
		return newTestimonial;
	}
	
	@RequestMapping("/testimonial/delete/{id}")
	public ModelAndView deleteTestimonial(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("admin-dashboard");
		testimonialService.deleteTestimonial(id);
		view.addObject("amenitiesList", amenitiesService.getAllAmenities());
		view.addObject("testimonialList", testimonialService.getAllTestimonials());
		return view;
	}

}






