package com.example.hotelapi.services;

import com.example.hotelapi.web.dtos.response.BaseResponse;

public interface IPaymentService {

    BaseResponse getPaymentMethods();
}
