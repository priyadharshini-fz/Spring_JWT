package com.springsecurity.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.entity.Reservation;
import com.springsecurity.exception.ReservationNotFoundException;
import com.springsecurity.repository.ReservationRepository;


@Service
public class ReservationService {

	@Autowired
    ReservationRepository reservationRepository;

	 public void saveReservation(Reservation reservation) {
		 reservation.setBookedAt(new Timestamp(System.currentTimeMillis()));

	         reservationRepository.save(reservation);
	    }
	 
    public List<Reservation> getAllReservations() {
      
		List<Reservation> reservation = reservationRepository.findAll();

		if (reservation.size() > 0) {
			return reservation;
		} 
		else {
			return new ArrayList<Reservation>();
		}
	}


    public Reservation getReservationById(int id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);

		if (reservation.isPresent()) {
			return reservation.get();
		} 
		else {
			throw new ReservationNotFoundException("No Reservation record exist for given id"+id);
		}
    }

   /* public List<Reservation> getReservationsByPassengerId(int passanger) {
        return reservationRepository.findByPassanger(passanger);
    }*/
    public List<Reservation> getReservationsByPassengerId(int passengerId) {
        return reservationRepository.findByPassengerId(passengerId);
    }


    public void deleteReservation(int id) {
    	reservationRepository.deleteById(id);
    }

}
