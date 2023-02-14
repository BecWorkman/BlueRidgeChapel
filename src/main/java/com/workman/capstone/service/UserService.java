package com.workman.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workman.capstone.model.User;
import com.workman.capstone.repository.AmenitiesRepository;
import com.workman.capstone.repository.UserRepository;

@Service
public class UserService {
	
	
	UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public UserRepository getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User loginUser(String email) {
		return userRepo.findByEmail(email);
	}
	
	

}
