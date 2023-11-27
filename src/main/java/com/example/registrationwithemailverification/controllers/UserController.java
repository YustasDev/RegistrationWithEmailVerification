package com.example.registrationwithemailverification.controllers;


import com.example.registrationwithemailverification.DTO.UserDto;
import com.example.registrationwithemailverification.entity.ConfirmationToken;
import com.example.registrationwithemailverification.entity.User;
import com.example.registrationwithemailverification.exception.UserNotFoundException;
import com.example.registrationwithemailverification.response.GenericResponse;
import com.example.registrationwithemailverification.service.UserService;
import com.example.registrationwithemailverification.service.UserServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/name")
    public GenericResponse<String> getName() {
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Get Name Successfull!")
                .data("Noname")
                .build();
    }


    @GetMapping("/username/{username}")
    public GenericResponse<UserDto> getByUsername(@RequestParam("token") String confirmationToken,
            @PathVariable("username") String username){
        Optional<User> userOptional = (Optional<User>) userService.findUserByUserName(confirmationToken, username)
                .orElseThrow(UserNotFoundException::new);
        User user = userOptional.get();
        String createdDate = userService.findCreated_dateByUser_id(user.getUserId(), confirmationToken);

        UserDto userDto = new UserDto(user.getUserId().toString(), user.getUserName(), createdDate);
        return GenericResponse.success(userDto);
    }




}
