package com.example.registrationwithemailverification.exception;



public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("A user with this name is missing from the database!");
    }
}
