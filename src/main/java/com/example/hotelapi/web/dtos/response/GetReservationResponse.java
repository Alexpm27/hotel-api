package com.example.hotelapi.web.dtos.response;
import com.example.hotelapi.persintence.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetReservationResponse {
    private Long id;
    private String date;
    private Status status;
    private RoomResponse room;
    private UserResponse user;
}
