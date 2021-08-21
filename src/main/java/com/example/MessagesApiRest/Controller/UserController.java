package com.example.MessagesApiRest.Controller;

import com.example.MessagesApiRest.Domain.User;
import com.example.MessagesApiRest.Service.UserService;
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

    @GetMapping("/")
    public String index (){
        return "index.html";
    }

    @GetMapping("/login")
    public String registrationForm(Model model){
        model.addAttribute("user", new User());
        return "login.html";
    }

    @PostMapping("/login")
    public String singIn(@Valid @ModelAttribute User user, BindingResult result, Model model){
        if (result.hasErrors()){
            return "redirect:/login.html";
        }
        else{
            model.addAttribute("user", userService.singIn(user));
        }
        return "redirect:/index.html";

    }




    }

