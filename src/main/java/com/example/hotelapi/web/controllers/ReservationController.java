package com.example.hotelapi.web.controllers;

import com.example.hotelapi.services.IReservationService;
import com.example.hotelapi.web.dtos.request.CreateReservationRequest;
import com.example.hotelapi.web.dtos.request.UpdateReservationRequest;
import com.example.hotelapi.web.dtos.response.BaseResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RestController("reservation")
@AllArgsConstructor
@NoArgsConstructor
public class ReservationController {

    private IReservationService service;

    @PostMapping("create/v1/user/{userId}/room/{roomId}")
    public ResponseEntity<BaseResponse> create(@Valid @RequestBody CreateReservationRequest request,
                                               @Valid @PathVariable Long userId,
                                               @Valid @PathVariable Long roomId){
        return service.create(request, userId, roomId).apply();
    }

    @PutMapping("update/v1/reservation/{reservationId}")
    public ResponseEntity<BaseResponse> update(@Valid @RequestBody UpdateReservationRequest request,
                                               @Valid @PathVariable Long reservationId){
        return service.update(request, reservationId).apply();
    }

    @GetMapping("get/v1/{reservationId}")
    public ResponseEntity<BaseResponse> get(@Valid @PathVariable Long reservationId){
        return service.get(reservationId).apply();
    }

    @GetMapping("get-all/reservations/user/{userId}")
    public ResponseEntity<BaseResponse> ListReservationsByUserId(@Valid @PathVariable Long userId){
        return service.listReservationsByUserId(userId).apply();
    }

    @DeleteMapping("delete/v1/{reservationId}")
    public ResponseEntity<BaseResponse> delete(@Valid @PathVariable Long reservationId){
        return service.delete(reservationId).apply();
    }

}