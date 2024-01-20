package com.example.hotelapi.persintence.models;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Calendar;

@Entity
@Setter
@Getter
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String date;

    @Column(nullable = false)
    @NotBlank
    private String hour;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    private Room room;

    @ManyToOne
    private User user;

}
