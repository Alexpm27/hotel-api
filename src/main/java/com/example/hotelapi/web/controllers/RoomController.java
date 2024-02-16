package com.example.hotelapi.web.controllers;

import com.example.hotelapi.services.IRoomService;
import com.example.hotelapi.web.dtos.response.BaseResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("room")
public class RoomController {

    private final IRoomService service;

    public RoomController(IRoomService service) {this.service = service;}

    @GetMapping("get/v1/{roomId}")
    public ResponseEntity<BaseResponse> get(@Valid @PathVariable Long roomId){
        return service.getRoomByID(roomId).apply();
    }

}
