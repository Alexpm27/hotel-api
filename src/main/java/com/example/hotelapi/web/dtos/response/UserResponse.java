package com.example.hotelapi.web.dtos.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class UserResponse {

    private Long id;

    private String name;

    private String lastName;

    private String email;

}