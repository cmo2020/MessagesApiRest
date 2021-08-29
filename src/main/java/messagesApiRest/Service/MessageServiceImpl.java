package messagesApiRest.Service;

import messagesApiRest.Domain.Label;
import messagesApiRest.Domain.Message;
import messagesApiRest.Repository.LabelRepository;
import messagesApiRest.Repository.MessageRepository;
import messagesApiRest.Repository.UserRepository;
import messagesApiRest.ServiceInterface.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl  implements MessageService {


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
    public List<Message> filterByLabel( String labelName) {

        List<Message> list = messageRepository.findAll().stream()
                .filter(message -> message.getLabel().equals(labelName)).collect(Collectors.toList());
       return list;

}


}