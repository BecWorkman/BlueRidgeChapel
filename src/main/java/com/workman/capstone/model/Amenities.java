package com.workman.capstone.model;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

/**
 * 
 * @author Becky Workman
 * This POJO is used to facilitate amenity creation and 
 * getting amenity information for each property location.
 *
 */
@Data
@Entity
public class Amenities{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private Long propertyLocation;
	
	
	public Amenities() {}


	public Amenities(Long id, String name, String description, Long propertyLocation) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.propertyLocation = propertyLocation;
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

	public Long getPropertyLocation() {
		return propertyLocation;
	}

	public void setPropertyLocation(Long propertyLocation) {
		this.propertyLocation = propertyLocation;
	}
	
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public int hashCode() {
		return Objects.hash(description, id, name, propertyLocation);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amenities other = (Amenities) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(propertyLocation, other.propertyLocation);
	}


	@Override
	public String toString() {
		return "Amenities [id=" + id + ", name=" + name + ", description=" + description + ", propertyLocation="
				+ propertyLocation + "]";
	}
}
