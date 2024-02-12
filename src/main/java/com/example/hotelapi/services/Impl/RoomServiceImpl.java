package com.example.hotelapi.services.Impl;

import com.example.hotelapi.persintence.enums.Status;
import com.example.hotelapi.persintence.exceptions.NotFoundException;
import com.example.hotelapi.persintence.models.Room;
import com.example.hotelapi.persintence.repositories.IRoomRepository;
import com.example.hotelapi.services.IRoomService;
import com.example.hotelapi.web.dtos.response.RoomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements IRoomService {

    private final IRoomRepository repository;

    public RoomServiceImpl(IRoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public Room findAndEnsureExists(Long roomId) {
        return repository.findById(roomId).orElseThrow(NotFoundException::new);
    }

    @Override
    public RoomResponse from(Room room) {
        return RoomResponse.builder()
                .id(room.getId())
                .name(room.getName())
                .price(room.getPrice())
                .status(room.getStatus())
                .description(room.getDescription())
                .build();
    }

}