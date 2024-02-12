package com.example.hotelapi.services;

import com.example.hotelapi.persintence.models.PaymentMethods;
import com.example.hotelapi.web.dtos.response.BaseResponse;

import java.util.List;

public interface IPaymentMethodService {

    BaseResponse getPaymentMethods();
}
