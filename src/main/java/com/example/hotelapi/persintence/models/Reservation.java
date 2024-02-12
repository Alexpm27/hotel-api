package com.example.hotelapi.persintence.models;
import com.example.hotelapi.persintence.enums.Status;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

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
    private String dateReservation;

    @Column(nullable = false)
    @NotBlank
    private String hourReservation;

    @Column(nullable = false)
    @NotBlank
    private String dateReserved;

    @Column(nullable = false)
    @NotBlank
    private String hourReserved;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Room room;

    @ManyToOne
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

}
