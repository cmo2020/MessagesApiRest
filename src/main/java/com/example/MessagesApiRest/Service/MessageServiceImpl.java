package com.example.MessagesApiRest.Service;

import com.example.MessagesApiRest.Domain.Message;
import com.example.MessagesApiRest.Repository.MessageRepository;
import com.example.MessagesApiRest.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl {


    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public MessageServiceImpl(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }





}


