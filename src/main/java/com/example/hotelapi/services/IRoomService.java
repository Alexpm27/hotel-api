package com.example.hotelapi.services;

import com.example.hotelapi.persintence.models.Room;
import com.example.hotelapi.web.dtos.response.RoomResponse;

public interface IRoomService {

    Room findAndEnsureExists(Long roomId);

    RoomResponse from(Room room);

}