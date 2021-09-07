package messagesApiRest.Service;

import messagesApiRest.Domain.Label;

import messagesApiRest.Domain.Message;
import messagesApiRest.Repository.LabelRepository;
import messagesApiRest.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class LabelServiceImpl implements ILabelService {


     private LabelRepository labelRepository;

     private MessageRepository messageRepository;


    @Autowired
    public LabelServiceImpl(MessageRepository messageRepository, LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
        this.messageRepository = messageRepository;

    }

    public LabelServiceImpl() {

    }


    @Override
    public Object createLabel( Label label) {
        labelRepository.save(label);
            return "label saved";


    }




    @Override
    public String removeLabel(Long id) {
        labelRepository.deleteById(id);
        return "Label removed";

    }

    @Override
    public Object addLabel(Long labelId, Long messageId) {

            Optional<Label> labelOptional = labelRepository.findById(labelId);
            Optional<Message> messageOptional = messageRepository.findById(messageId);
            Message messages = messageOptional.get();
            Label labels = labelOptional.get();
            messages.setLabel(labels);
            messageRepository.save(messages);

            return "label added";


    }



}
