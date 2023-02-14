package com.workman.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.workman.capstone.service.PropertyService;

@Controller
public class PropertyController {
	
	@Autowired
	PropertyService propertyService;

}
