package com.workman.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workman.capstone.repository.ReservationRepository;

@Service
public class ReservationService {
	
	
	ReservationRepository reservationRepo;
	
	public ReservationService(ReservationRepository reservationRepo) {
		this.reservationRepo = reservationRepo;
	}

	public ReservationRepository getReservationRepo() {
		return reservationRepo;
	}

	public void setReservationRepo(ReservationRepository reservationRepo) {
		this.reservationRepo = reservationRepo;
	}
	
	

}
