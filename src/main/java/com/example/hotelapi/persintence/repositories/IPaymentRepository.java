package com.example.hotelapi.persintence.repositories;

import com.example.hotelapi.persintence.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {
}
