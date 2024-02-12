package com.example.hotelapi.web.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateReservationRequest {

    @NotBlank
    private String dateReserved;

    @NotBlank
    private String hourReserved;

}