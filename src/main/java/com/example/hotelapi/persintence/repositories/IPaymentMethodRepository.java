package com.example.hotelapi.persintence.repositories;

import com.example.hotelapi.persintence.models.PaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentMethodRepository extends JpaRepository<PaymentMethods, Long> {
}
