package com.example.registrationwithemailverification.controllers;


import com.example.registrationwithemailverification.entity.User;
import com.example.registrationwithemailverification.service.UserService;
import com.example.registrationwithemailverification.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> confirmUserAccount(@RequestParam("token")String confirmationToken) {
        return userService.confirmEmail(confirmationToken);
    }

    @GetMapping("/do_something")
    public ResponseEntity<?> do_something(@RequestParam("token") String confirmationToken){
        return userService.do_something(confirmationToken);

    }



}
