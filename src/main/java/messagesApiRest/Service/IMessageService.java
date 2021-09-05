package messagesApiRest.Service;


import messagesApiRest.Domain.Label;
import messagesApiRest.Domain.Message;
import messagesApiRest.Domain.User;

import org.springframework.data.domain.Pageable;

public interface IMessageService {

    Message createMessage (Message message);

    Object  receivedMessages(User user, Message message, Pageable pageable);

    Object sentMessages(User user, Message message, Pageable pageable);

    Object filterByLabel (Message message,  Long idLabel,   Pageable pageable);

    String deleteMessage (Long id);




}