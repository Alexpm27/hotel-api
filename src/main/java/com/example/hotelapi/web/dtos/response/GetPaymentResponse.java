package com.example.hotelapi.web.dtos.response;

import com.example.hotelapi.persintence.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GetPaymentResponse {
    private Long id;
    private String type;
    private Status status;
    private ReservationResponse reservation;
}