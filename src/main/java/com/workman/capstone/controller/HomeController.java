package com.workman.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.workman.capstone.model.User;
import com.workman.capstone.model.UserDto;
import com.workman.capstone.service.AmenitiesService;
import com.workman.capstone.service.TestimonialService;


@Controller
public class HomeController {
	
	
	private final AmenitiesService AMENITIES_SERVICE;
	private final TestimonialService TESTIMONIAL_SERVICE;
	
	public HomeController(AmenitiesService amenitiesService, TestimonialService testimonialService) {
		super();
		this.AMENITIES_SERVICE = amenitiesService;
		this.TESTIMONIAL_SERVICE = testimonialService;
	}

	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("/about")
	public ModelAndView about() {
		ModelAndView list = new ModelAndView("about");
		list.addObject("amenitiesList", AMENITIES_SERVICE.getAllAmenities());
		return list;
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "register";
	}
	
	

	/*
	@PostMapping("/register/save")
	public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model){
		User existingUser = userService.findUserByEmail(userDto.getEmail());
		if(existingUser != null && existingUser.getEmail() != null &&
				!existingUser.getEmail().isEmpty()){
			result.rejectValue("email", null,"There is already an account registered with the same email");
		}
		if(result.hasErrors()){
			model.addAttribute("user", userDto);
			return "/register";
		}
		userService.saveUser(userDto);
		return "redirect:/register?success";
	}*/
	
	@GetMapping("/dashboard")
	public ModelAndView loginUser() {
		ModelAndView list = new ModelAndView("admin-dashboard");
		list.addObject("amenitiesList", AMENITIES_SERVICE.getAllAmenities());
		list.addObject("testimonialList", TESTIMONIAL_SERVICE.getAllTestimonials());
		return list;
	}

}
