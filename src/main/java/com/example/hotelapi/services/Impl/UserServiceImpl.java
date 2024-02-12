package com.example.hotelapi.services.Impl;

import com.example.hotelapi.persintence.exceptions.NotFoundException;
import com.example.hotelapi.persintence.models.Reservation;
import com.example.hotelapi.persintence.models.Room;
import com.example.hotelapi.persintence.models.User;
import com.example.hotelapi.persintence.repositories.IUserRepository;
import com.example.hotelapi.services.IUserService;
import com.example.hotelapi.web.dtos.request.CreateUserRequest;
import com.example.hotelapi.web.dtos.request.UpdateUserRequest;
import com.example.hotelapi.web.dtos.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository repository;
    @Override
    public BaseResponse get(String email) {
        return BaseResponse.builder()
                .data(fromUserToGetUserResponse(findUserByEmailAndEnsureExists(email)))
                .message("User Obtained")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse ListReservationsByUserId(Long userId) {
        return BaseResponse.builder()
                .data(getReservationList(userId))
                .message("Reservations List By User")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse create(CreateUserRequest request) {
        return BaseResponse.builder()
                .data(from(repository.save(from(request))))
                .message("User Created Correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse update(UpdateUserRequest request, Long id) {
        return BaseResponse.builder()
                .data(fromUserToUpdateUserResponse(repository.save(from(request, id))))
                .message("User Updated Correctly")
                .httpStatus(HttpStatus.OK)
                .success(Boolean.TRUE)
                .build();
    }

    @Override
    public BaseResponse delete(Long id) {
        repository.delete(findAndEnsureExists(id));
        return BaseResponse.builder()
                .message("User Deleted Correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    private User findUserByEmailAndEnsureExists(String email) {
        return repository.findByEmail(email).orElseThrow(NotFoundException::new);
    }

    private GetUserResponse fromUserToGetUserResponse(User user) {
        return GetUserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .password(user.getPassword()).build();
    }

    private List<GetReservationResponse> getReservationList(Long userId){
        return findAndEnsureExists(userId)
                .getReservations()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    private GetReservationResponse from(Reservation reservation){
        return GetReservationResponse.builder()
                .date(reservation.getDateReserved())
                .status(reservation.getStatus())
                .id(reservation.getId())
                .user(fromUserToUserResponse(reservation.getUser()))
                .room(fromRestaurantToRestaurantResponse(reservation.getRoom()))
                .build();
    }

    @Override
    public UserResponse fromUserToUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .build();
    }

    @Override
    public User findAndEnsureExists(Long userId){
        return repository.findById(userId).orElseThrow(NotFoundException::new);
    }

    private RoomResponse fromRestaurantToRestaurantResponse(Room room){
        return RoomResponse.builder()
                .id(room.getId())
                .name(room.getName())
                .build();
    }

    private User from(CreateUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(request.getPassword());
        return user;
    }

    private CreateUserResponse from(User user) {
        return CreateUserResponse.builder()
                .phoneNumber(user.getPhoneNumber())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .name(user.getName())
                .id(user.getId()).build();
    }

    private User from(UpdateUserRequest request, Long id){
        User user = findAndEnsureExists(id);
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(request.getPassword());
        return user;
    }

    private UpdateUserResponse fromUserToUpdateUserResponse(User user){
        return UpdateUserResponse.builder()
                .lastName(user.getLastName())
                .email(user.getEmail())
                .id(user.getId())
                .phoneNumber(user.getPhoneNumber())
                .name(user.getName()).build();
    }

}
