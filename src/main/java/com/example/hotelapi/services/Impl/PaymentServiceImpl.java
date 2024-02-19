package com.example.hotelapi.services.Impl;

import com.example.hotelapi.persintence.models.Payment;
import com.example.hotelapi.persintence.repositories.IPaymentRepository;
import com.example.hotelapi.services.IPaymentService;
import com.example.hotelapi.services.IReservationService;
import com.example.hotelapi.web.dtos.response.BaseResponse;
import com.example.hotelapi.web.dtos.response.GetPaymentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements IPaymentService {

    private final IPaymentRepository paymentRepository;

    private final IReservationService reservationService;


    public PaymentServiceImpl(IPaymentRepository paymentRepository, IReservationService reservationService) {
        this.paymentRepository = paymentRepository;
        this.reservationService = reservationService;
    }

    @Override
    public BaseResponse getPaymentMethods() {

        return BaseResponse.builder()
                .data(from(paymentRepository.findAll()))
                .message("Payment methods name obtained")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.FOUND)
                .statusCode(302).build();
    }

    private List<GetPaymentResponse> from(List<Payment> methods){
        return methods.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public GetPaymentResponse from(Payment methods) {
        return GetPaymentResponse.builder()
                .id(methods.getId())
                .type(methods.getType())
                .reservation(reservationService.from(methods.getReservation()))
                .build();
    }

}
