package com.example.hotelapi.services.Impl;

import com.example.hotelapi.persintence.models.PaymentMethods;
import com.example.hotelapi.persintence.repositories.IPaymentMethodRepository;
import com.example.hotelapi.services.IPaymentMethodService;
import com.example.hotelapi.web.dtos.response.BaseResponse;
import com.example.hotelapi.web.dtos.response.GetPaymentMethodsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentMethodServiceImpl implements IPaymentMethodService {

    @Autowired
    IPaymentMethodRepository paymentMethodRepository;

    @Override
    public BaseResponse getPaymentMethods() {

        return BaseResponse.builder()
                .data(from(paymentMethodRepository.findAll()))
                .message("Payment methods name obtained")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.FOUND)
                .statusCode(302).build();
    }

    private List<GetPaymentMethodsResponse> from(List<PaymentMethods> methods){
        return methods.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public GetPaymentMethodsResponse from(PaymentMethods methods) {
        return GetPaymentMethodsResponse.builder()
                .id(methods.getId())
                .paymentName(methods.getPaymentName()).build();
    }

}
