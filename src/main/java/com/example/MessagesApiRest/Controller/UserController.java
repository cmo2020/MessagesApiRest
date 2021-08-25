package com.example.MessagesApiRest.Controller;

import com.example.MessagesApiRest.Domain.User;
import com.example.MessagesApiRest.Service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }




    @PostMapping("/singIn")
    public ResponseEntity<User> SingIn (@Valid @RequestBody User user){

        userService.singIn(user);
        return new ResponseEntity<User>(HttpStatus.CREATED);

    }




    }

