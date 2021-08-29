package messagesApiRest.ServiceInterface;

import messagesApiRest.Domain.Label;
import messagesApiRest.Domain.Message;

import java.util.List;

public interface MessageService {

    List<Message> filterByLabel(String labelName) ;





}