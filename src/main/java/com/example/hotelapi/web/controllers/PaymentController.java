package com.example.hotelapi.web.controllers;

import com.example.hotelapi.services.IPaymentService;
import com.example.hotelapi.web.dtos.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("payment")
public class PaymentController {

    private final IPaymentService service;

    public PaymentController(IPaymentService service) {
        this.service = service;
    }

    @GetMapping("get/payment-methods")
    public ResponseEntity<BaseResponse> getPaymentMethods(){
        return service.getPaymentMethods().apply();
    }
}
