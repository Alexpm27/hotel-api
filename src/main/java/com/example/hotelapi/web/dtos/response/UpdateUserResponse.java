package com.example.hotelapi.web.dtos.response;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateUserResponse {
    private Long id;
    private String email;
    private String name;
    private String lastName;
    private Long phoneNumber;
}
