package com.example.hotelapi.persintence.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @NotBlank
    private String name;

    private String lastName;

    @Column(unique=true)
    @Email
    private String email;

    private String password;

    private Long phoneNumber;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;

}
