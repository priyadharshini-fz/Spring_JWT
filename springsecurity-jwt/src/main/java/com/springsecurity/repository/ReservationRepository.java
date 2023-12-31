package com.springsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.entity.Reservation;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

//	List<Reservation> findByPassanger(int passanger);
	List<Reservation> findByPassengerId(int passengerId);


}
