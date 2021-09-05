package messagesApiRest.Service;


import messagesApiRest.Domain.Label;
import messagesApiRest.Domain.Message;
import messagesApiRest.Domain.User;

import messagesApiRest.Repository.LabelRepository;
import messagesApiRest.Repository.MessageRepository;
import messagesApiRest.Repository.UserRepository;
import messagesApiRest.Security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;


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
            return messageRepository.save(newMessage);
        }
        return message;
    }





    public Object receivedMessages(User user, Message message, Pageable pageable) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails) {

            String userEmail = ((CustomUserDetails) principal).getEmail(user.getEmail());
           return messageRepository.findByRecipient(message, pageable)
                   .stream().filter(message1 -> message1.getBcc().equals(userEmail)
                           ||  message1.getRecipient().equals(userEmail)
                                || message1.getCc().equals(userEmail));


            }
                    
            else   return "unauthorized";

    }

    @Override
    public Object  sentMessages(User user, Message message, Pageable pageable) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails) {
            String userEmail = ((CustomUserDetails) principal).getEmail(user.getEmail());
            return messageRepository.findByRecipient(message, pageable)
                    .stream().filter(message1 -> message1.getDeriveFrom().equals(userEmail));

        } else return "unauthorized";
    }

    @Override
    public Object filterByLabel(Message message, Long idLabel,  Pageable pageable) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails) {

            Optional<Label> labelOptional = labelRepository.findById(idLabel);
             Label labels = labelOptional.get();
        return   messageRepository.filterByLabel(idLabel, pageable).stream()
                .filter(message1 -> message1.getLabel().equals(labels));



        }
        return "unauthorized";
    }

    @Override
    public String deleteMessage (Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails) {
            messageRepository.deleteById(id);
            return "Message removed";

        }
        return "unauthorized";
    }

    }


