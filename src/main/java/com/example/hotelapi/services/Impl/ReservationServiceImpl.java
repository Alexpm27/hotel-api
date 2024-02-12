package com.example.hotelapi.services.Impl;

import com.example.hotelapi.persintence.enums.Status;
import com.example.hotelapi.persintence.exceptions.NotFoundException;
import com.example.hotelapi.persintence.models.Reservation;
import com.example.hotelapi.persintence.repositories.IReservationRepository;
import com.example.hotelapi.services.IReservationService;
import com.example.hotelapi.services.IRoomService;
import com.example.hotelapi.services.IUserService;
import com.example.hotelapi.web.dtos.request.CreateReservationRequest;
import com.example.hotelapi.web.dtos.request.UpdateReservationRequest;
import com.example.hotelapi.web.dtos.response.BaseResponse;
import com.example.hotelapi.web.dtos.response.ReservationResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private IReservationRepository repository;

    private IUserService userService;

    private IRoomService roomService;

    @Override
    public BaseResponse create(CreateReservationRequest request, Long userId, Long roomId) {
        return BaseResponse.builder()
                .data(from(repository.save(from(request, userId, roomId))))
                .message("Reservation completed")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .statusCode(201).build();
    }

    @Override
    public BaseResponse update(UpdateReservationRequest request, Long reservationId) {
        return BaseResponse.builder()
                .data(from(repository.save(from(request, reservationId))))
                .message("Reservation updated")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .statusCode(200).build();
    }

    @Override
    public BaseResponse get(Long reservationId) {
        return BaseResponse.builder()
                .data(from(findAndEnsureExists(reservationId)))
                .message("Reservation obtained")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.FOUND)
                .statusCode(302).build();
    }

    @Override
    public BaseResponse listReservationsByUserId(Long userId) {
        return BaseResponse.builder()
                .data(from(findAllReservationsByUserId(userId)))
                .message("Reservation List")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .statusCode(200).build();
    }

    @Override
    public BaseResponse delete(Long reservationId) {
        repository.deleteById(reservationId);
        return BaseResponse.builder()
                .message("Reservation deleted")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .statusCode(200).build();
    }

    @Override
    public Reservation findAndEnsureExists(Long reservationId) {
        return repository.findById(reservationId).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Reservation> findAllReservationsByUserId(Long userId) {
        return userService.findAndEnsureExists(userId).getReservations();
    }

    @Override
    public ReservationResponse from(Reservation reservation) {
        return ReservationResponse.builder()
                .id(reservation.getId())
                .user(userService.fromUserToUserResponse(reservation.getUser()))
                .hourReserved(reservation.getHourReserved())
                .dateReserved(reservation.getDateReserved())
                .status(reservation.getStatus())
                .room(roomService.from(reservation.getRoom())).build();
    }

    @Override
    public List<ReservationResponse> from(List<Reservation> reservationList) {
        return reservationList.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    private Reservation from(CreateReservationRequest request, Long userId, Long roomId){
        Reservation reservation = new Reservation();
        reservation.setDateReserved(request.getDateReserved());
        reservation.setHourReserved(request.getHourReserved());
        reservation.setDateReservation(LocalDateTime.now().toLocalDate().toString());
        reservation.setHourReservation(LocalDateTime.now().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        reservation.setStatus(Status.PENDING);
        reservation.setUser(userService.findAndEnsureExists(userId));
        reservation.setRoom(roomService.findAndEnsureExists(roomId));
        return reservation;
    }

    private Reservation from(UpdateReservationRequest request, Long reservationId){
        Reservation reservation = findAndEnsureExists(reservationId);
        reservation.setDateReserved(request.getDateReserved());
        reservation.setHourReserved(request.getHourReserved());
        reservation.setDateReservation(LocalDateTime.now().toLocalDate().toString());
        reservation.setHourReservation(LocalDateTime.now().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        reservation.setStatus(reservation.getStatus());
        reservation.setUser(reservation.getUser());
        reservation.setRoom(reservation.getRoom());
        reservation.setPayment(reservation.getPayment());
        return reservation;
    }

}