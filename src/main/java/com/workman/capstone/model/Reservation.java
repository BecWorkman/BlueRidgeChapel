package com.workman.capstone.model;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * 
 * @author Becky Workman
 * This POJO is used to facilitate reservation creation and 
 * getting reservation information.
 *
 */

@Entity
public class Reservation{
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	private Long userId;
	private Date checkInDate;
	private Date checkOutDate;
	private int numberOfGuests;
	private String petStatus;
	private Long propertyLocation;

	public Reservation(){}

	public Reservation(Long userId, Date checkInDate, Date checkOutDate, int numberOfGuests, String petStatus) {
		super();
		this.userId = userId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numberOfGuests = numberOfGuests;
		this.petStatus = petStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public String getPetStatus() {
		return petStatus;
	}

	public void setPetStatus(String petStatus) {
		this.petStatus = petStatus;
	}

	public Long getPropertyLocation() {
		return propertyLocation;
	}

	public void setPropertyLocation(Long propertyLocation) {
		this.propertyLocation = propertyLocation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(checkInDate, checkOutDate, id, numberOfGuests, petStatus, propertyLocation, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(checkInDate, other.checkInDate) && Objects.equals(checkOutDate, other.checkOutDate)
				&& Objects.equals(id, other.id) && numberOfGuests == other.numberOfGuests
				&& Objects.equals(petStatus, other.petStatus)
				&& Objects.equals(propertyLocation, other.propertyLocation) && Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", userId=" + userId + ", checkInDate=" + checkInDate + ", checkOutDate="
				+ checkOutDate + ", numberOfGuests=" + numberOfGuests + ", petStatus=" + petStatus
				+ ", propertyLocation=" + propertyLocation + "]";
	}

	
}
