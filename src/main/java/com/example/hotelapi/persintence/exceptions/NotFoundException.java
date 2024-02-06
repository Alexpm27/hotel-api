package com.example.hotelapi.persintence.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("Data Not Found");
    }
}
