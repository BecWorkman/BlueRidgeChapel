package com.workman.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.workman.capstone.service.AmenitiesService;
import com.workman.capstone.service.TestimonialService;
import com.workman.capstone.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	AmenitiesService amenitiesService;
	
	@Autowired
	TestimonialService testimonialService;
	
	@RequestMapping("/userLogin")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/adminDashboard")
	public ModelAndView loginUser() {
		ModelAndView list = new ModelAndView("admin-dashboard");
		list.addObject("amenitiesList", amenitiesService.getAllAmenities());
		list.addObject("testimonialList", testimonialService.getAllTestimonials());
		return list;
	}
	
	
	@RequestMapping("/users/new")
	public String addNewUser() {
		return "hi";
	}
}
