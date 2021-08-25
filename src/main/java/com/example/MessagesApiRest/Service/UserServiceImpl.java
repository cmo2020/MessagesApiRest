package com.example.MessagesApiRest.Service;

import com.example.MessagesApiRest.Domain.User;
import com.example.MessagesApiRest.Repository.UserRepository;
import com.example.MessagesApiRest.Security.PasswordConfig;
import com.example.MessagesApiRest.ServiceInterface.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


     private final UserRepository userRepository;
     private  PasswordConfig passwordConfig;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


@Override
    public  User singIn(User user){
        user.setPassword(passwordConfig.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }





}
