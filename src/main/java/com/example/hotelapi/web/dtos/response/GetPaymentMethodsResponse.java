package com.example.hotelapi.web.dtos.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GetPaymentMethodsResponse {

    private Long id;
    private String paymentName;
}
