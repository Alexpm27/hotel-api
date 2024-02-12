package com.example.hotelapi.persintence.repositories;

import com.example.hotelapi.persintence.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomRepository extends JpaRepository<Room, Long> {

}
