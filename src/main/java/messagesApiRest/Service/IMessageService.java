package messagesApiRest.Service;


import messagesApiRest.Domain.Label;
import messagesApiRest.Domain.Message;
import messagesApiRest.Domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMessageService {

    Message createMessage (Message message);

    Page<Message> receivedMessages(User user, Message message, Pageable pageable);

    Page<Message> sentMessages(User user, Message message, Pageable pageable);

    Page<Message> filterByLabel (Message message,  Long idLabel,   Pageable pageable);

    String deleteMessage (Long id);




}