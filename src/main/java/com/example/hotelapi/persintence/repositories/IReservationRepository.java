package com.example.hotelapi.persintence.repositories;

import com.example.hotelapi.persintence.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long> {

}
