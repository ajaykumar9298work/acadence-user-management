package com.user_management.controller;

import com.user_management.models.request.user.CreateUserRequest;
import com.user_management.services.user.UserRegisterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserRegisterService userRegisterService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        CreateUserRequest user = userRegisterService.createUser(createUserRequest);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
