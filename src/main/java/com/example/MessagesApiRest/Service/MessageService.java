package com.example.MessagesApiRest.Service;

import com.example.MessagesApiRest.Domain.Message;
import com.example.MessagesApiRest.Repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {


    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public  Message sendMessage(Message message){
    this.sendMessage(message);
        return message;
    }
    }





