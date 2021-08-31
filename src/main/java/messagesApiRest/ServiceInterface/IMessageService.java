package messagesApiRest.ServiceInterface;

import messagesApiRest.Domain.Label;
import messagesApiRest.Domain.Message;
import messagesApiRest.Domain.User;
import org.springframework.security.core.Authentication;

import java.awt.print.Pageable;
import java.security.Principal;
import java.util.List;
import java.util.Map;

public interface IMessageService {

    List<Message> filterByLabel(String labelName) ;

    Message createMessage (Message message);

    Message addLabel (Label label, Long id);

    List<Message>  receivedMessages(User user, Message message);




}