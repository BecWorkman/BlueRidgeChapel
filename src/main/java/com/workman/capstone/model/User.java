package com.workman.capstone.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;


/**
 * 
 * @author Becky Workman
 * This POJO is used to facilitate user creation and 
 * getting user information.
 *
 */

@Entity
public class User{
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private String password;
	private String status;
	
	@ManyToMany(targetEntity = Testimonial.class)
	private Set<Testimonial> userTestimonials;
	
	@ManyToMany(targetEntity = Reservation.class)
	private Set<Reservation> userReservations;
	

		
	public User() {}

	public User(String name, String email, String password, String status) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, password, status, userReservations, userTestimonials);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(status, other.status)
				&& Objects.equals(userReservations, other.userReservations)
				&& Objects.equals(userTestimonials, other.userTestimonials);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", status="
				+ status + ", userTestimonials=" + userTestimonials + ", userReservations=" + userReservations + "]";
	}




}
