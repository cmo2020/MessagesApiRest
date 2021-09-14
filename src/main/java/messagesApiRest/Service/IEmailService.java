package messagesApiRest.Service;

import messagesApiRest.Domain.Bcc;
import messagesApiRest.Domain.Cc;
import messagesApiRest.Domain.Message;
import messagesApiRest.Domain.Recipients;

import javax.mail.MessagingException;

public interface IEmailService {



    void sendSimpleMessage(Message message, Recipients recipients, Cc cc, Bcc bcc);

    void sendMessageWithAttachment(Message message, Recipients recipients) throws MessagingException;

}

