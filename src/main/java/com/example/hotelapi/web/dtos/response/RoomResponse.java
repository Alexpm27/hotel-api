package com.example.hotelapi.web.dtos.response;
import com.example.hotelapi.persintence.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class RoomResponse {
    private Long id;
    private String name;
    private String description;
    private Float price;
    private Status status;
}
