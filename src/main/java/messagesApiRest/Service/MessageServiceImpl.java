package messagesApiRest.Service;

import messagesApiRest.Domain.Label;
import messagesApiRest.Domain.Message;
import messagesApiRest.Domain.User;
import messagesApiRest.Repository.LabelRepository;
import messagesApiRest.Repository.MessageRepository;
import messagesApiRest.Repository.UserRepository;
import messagesApiRest.Security.CustomUserDetails;
import messagesApiRest.ServiceInterface.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl  implements IMessageService {


    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final LabelRepository labelRepository;


    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, UserRepository userRepository, LabelRepository labelRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.labelRepository = labelRepository;
    }


    @Override
    public List<Message> filterByLabel(String labelName) {

        List<Message> list = messageRepository.findAll().stream()
                .filter(message -> message.getLabel().equals(labelName)).collect(Collectors.toList());
        return list;

    }

    @Override
    public Message createMessage(Message message) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails) {
            Message newMessage = new Message();
            newMessage.setDeriveFrom(message.getDeriveFrom());
            newMessage.setSubject(message.getSubject());
            newMessage.setRecipient(message.getRecipient());
            newMessage.setCc(message.getCc());
            newMessage.setBcc(message.getBcc());
            newMessage.setBody(message.getBody());
            newMessage.setAttachment(message.getAttachment());
            return messageRepository.save(message);
        }
        return message;
    }


    @Override
    public Message addLabel(Label label, Long id) {
        return messageRepository.getById(id).addLabel(label);
    }



    @Override
    public List<Message> receivedMessages(User user, Message message) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails) {
            String userEmail = ((CustomUserDetails) principal).getEmail(user.getEmail());
            return messageRepository.findByRecipient(userEmail);

        }
        else return  Collections.emptyList();

           }

    }




