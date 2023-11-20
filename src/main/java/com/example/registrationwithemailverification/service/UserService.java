package com.example.registrationwithemailverification.service;


import com.example.registrationwithemailverification.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> saveUser(User user);

    ResponseEntity<?> confirmEmail(String confirmationToken);
}
