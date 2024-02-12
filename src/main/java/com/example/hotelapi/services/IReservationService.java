package com.example.hotelapi.services;

import com.example.hotelapi.persintence.models.Reservation;
import com.example.hotelapi.web.dtos.request.CreateReservationRequest;
import com.example.hotelapi.web.dtos.request.UpdateReservationRequest;
import com.example.hotelapi.web.dtos.response.BaseResponse;
import com.example.hotelapi.web.dtos.response.ReservationResponse;

import java.util.List;

public interface IReservationService {

    BaseResponse create(CreateReservationRequest request, Long userId, Long roomId);

    BaseResponse update(UpdateReservationRequest request, Long reservationId);

    BaseResponse get(Long reservationId);

    BaseResponse listReservationsByUserId(Long userId);

    BaseResponse delete(Long reservationId);

    Reservation findAndEnsureExists(Long reservationId);

    List<Reservation> findAllReservationsByUserId(Long userId);

    ReservationResponse from(Reservation reservation);

    List<ReservationResponse> from(List<Reservation> reservationList);

}