package messagesApiRest.Service;


import messagesApiRest.Domain.*;

import messagesApiRest.Repository.LabelRepository;
import messagesApiRest.Repository.MessageRepository;
import messagesApiRest.Security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public Page<Message> receivedMessages(User user, Message message, Recipients recipients, Bcc bcc, Cc cc, Pageable pageable) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUserDetails) {

            String userEmail = ((CustomUserDetails) principal).getEmail(user.getEmail());
            String recipient1 = recipients.getRecipientOne();
            String recipient2 = recipients.getRecipientTwo();
            String recipient3 = recipients.getRecipientThree();
            String bcc1 = bcc.getBccOne();
            String bcc2 = bcc.getBccTwo();
            String bcc3 = bcc.getBccThree();
            String cc1 = cc.getCcOne();
            String cc2 = cc.getCcTwo();
            String cc3 = cc.getCcThree();

            List<Message> messagePage = messageRepository.findByRecipient(recipients, bcc, cc,pageable).
                    stream().filter(message1 -> userEmail.equals(recipient1) || userEmail.equals(recipient2) ||
                    userEmail.equals(recipient3)|| userEmail.equals(bcc1) || userEmail.equals(bcc2) ||
                    userEmail.equals(bcc3) || userEmail.equals(cc1) || userEmail.equals(cc2) ||
                    userEmail.equals(cc3)).collect(Collectors.toList());

            return new PageImpl<>(messagePage);


        }
        else return Page.empty();
    }

    @Override
    public Page<Message> sentMessages(User user, Message message, Pageable pageable) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUserDetails) {
            String userEmail = ((CustomUserDetails) principal).getEmail(user.getEmail());
            String from = message.getDeriveFrom();
            List<Message> messageList = messageRepository.findByDeriveFrom(message, pageable)
                    .stream().filter(message1 -> userEmail.equals(from)).collect(Collectors.toList());

            return  new PageImpl<Message>(messageList);


        }
        else return Page.empty();
    }

    @Override
    public Page<Message> filterByLabel(Message message, Long idLabel, Pageable pageable) {
        Optional<Label> labelOptional = labelRepository.findById(idLabel);
        Label labels = labelOptional.get();
        Label labelMessage = message.getLabel();
        List<Message> messageList = messageRepository.findByLabel(message, idLabel, pageable).stream()
                .filter(message1 ->
                        labelMessage.equals(labels)).collect(Collectors.toList());


        return new PageImpl<Message>(messageList);
    }


    @Override
    public String deleteMessage (Long id) {

        messageRepository.deleteById(id);
        return "Message removed";

    }

    }


