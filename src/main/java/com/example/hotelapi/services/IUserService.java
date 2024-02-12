package com.example.hotelapi.services;

import com.example.hotelapi.persintence.models.User;
import com.example.hotelapi.web.dtos.request.CreateUserRequest;
import com.example.hotelapi.web.dtos.request.UpdateUserRequest;
import com.example.hotelapi.web.dtos.response.BaseResponse;
import com.example.hotelapi.web.dtos.response.UserResponse;

public interface IUserService {
    BaseResponse get(String email);

    BaseResponse create(CreateUserRequest request);

    BaseResponse update(UpdateUserRequest request, Long id);

    BaseResponse delete (Long id);

    BaseResponse ListReservationsByUserId(Long userId);

    UserResponse fromUserToUserResponse(User user);

    User findAndEnsureExists(Long userId);

}