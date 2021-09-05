package messagesApiRest.Service;

import messagesApiRest.Domain.Message;

import javax.mail.MessagingException;

public interface IEmailService {



    void sendSimpleMessage(Message message);

    void sendMessageWithAttachment(Message message) throws MessagingException;

}

