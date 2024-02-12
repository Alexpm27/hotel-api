package com.example.hotelapi.web.controllers;

import com.example.hotelapi.services.IPaymentMethodService;
import com.example.hotelapi.web.dtos.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("payment")
public class PaymentMethodController {

    private final IPaymentMethodService service;

    public PaymentMethodController(IPaymentMethodService service) {
        this.service = service;
    }

    @GetMapping("get/payment-methods")
    public ResponseEntity<BaseResponse> getPaymentMethods(){
        return service.getPaymentMethods().apply();
    }
}
