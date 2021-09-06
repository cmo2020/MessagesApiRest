package messagesApiRest.Service;


import messagesApiRest.Domain.Label;
import messagesApiRest.Domain.Message;
import messagesApiRest.Domain.User;

import messagesApiRest.Repository.LabelRepository;
import messagesApiRest.Repository.MessageRepository;
import messagesApiRest.Security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.jayway.jsonpath.Filter.filter;


@Service
public class MessageServiceImpl  implements IMessageService {


    private final MessageRepository messageRepository;
    private final LabelRepository labelRepository;


    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, LabelRepository labelRepository) {
        this.messageRepository = messageRepository;

        this.labelRepository = labelRepository;
    }



    @Override
    public Message createMessage(Message message) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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





    public Page<Message> receivedMessages(User user, Message message, Pageable pageable) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUserDetails) {

            String userEmail = ((CustomUserDetails) principal).getEmail(user.getEmail());
            List<Message> messageStream =  messageRepository.findByRecipient(message, pageable)
                   .stream().filter(message1 -> message1.getBcc().equals(userEmail)
                           ||  message1.getRecipient().equals(userEmail)
                                || message1.getCc().equals(userEmail)).collect(Collectors.toList());

            return new PageImpl<Message>(messageStream);

            }
                    
            else   return Page.empty();

    }

    @Override
    public  Page<Message>   sentMessages(User user, Message message, Pageable pageable) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUserDetails) {
            String userEmail = ((CustomUserDetails) principal).getEmail(user.getEmail());
            List<Message> messageList = messageRepository.findBySender(message, pageable)
                    .stream().filter(message1 -> message1.getDeriveFrom().equals(userEmail)).collect(Collectors.toList());
                return  new PageImpl<Message>(messageList);
        } else return Page.empty();
    }

    @Override
    public Page<Message> filterByLabel(Message message, Long idLabel,  Pageable pageable) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUserDetails) {

            Optional<Label> labelOptional = labelRepository.findById(idLabel);
             Label labels = labelOptional.get();
             List<Message> messageList =  messageRepository.filterByLabel(idLabel, pageable).stream()
                .filter(message1 -> message1.getLabel().equals(labels)).collect(Collectors.toList());

                return new PageImpl<Message>(messageList);


        }
        return Page.empty();
    }

    @Override
    public String deleteMessage (Long id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUserDetails) {
            messageRepository.deleteById(id);
            return "Message removed";

        }
        return "unauthorized";
    }

    }


