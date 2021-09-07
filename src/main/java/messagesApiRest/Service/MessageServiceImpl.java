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
        return messageRepository.save(message);

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

            Optional<Label> labelOptional = labelRepository.findById(idLabel);
             Label labels = labelOptional.get();
             List<Message> messageList =  messageRepository.filterByLabel(idLabel, pageable).stream()
                .filter(message1 -> message1.getLabel().equals(labels)).collect(Collectors.toList());

                return new PageImpl<Message>(messageList);


    }

    @Override
    public String deleteMessage (Long id) {

        messageRepository.deleteById(id);
        return "Message removed";

    }

    }


