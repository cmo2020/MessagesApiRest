package com.example.MessagesApiRest.Controller;

import com.example.MessagesApiRest.Domain.User;
import com.example.MessagesApiRest.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }




    @PostMapping("/login")
    public ResponseEntity<User> SingIn (@Valid @RequestBody User user){
        userService.singIn(user);

        return new ResponseEntity<User>(HttpStatus.CREATED);


    }




    }

