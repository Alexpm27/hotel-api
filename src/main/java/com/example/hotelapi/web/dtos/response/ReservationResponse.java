package com.example.hotelapi.web.dtos.response;

import com.example.hotelapi.persintence.enums.Status;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReservationResponse {

    private Long id;
    private String dateReserved;
    private String hourReserved;
    private Status status;
    private UserResponse user;
    private RoomResponse room;

}