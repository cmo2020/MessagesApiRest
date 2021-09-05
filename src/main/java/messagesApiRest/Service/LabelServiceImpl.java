package messagesApiRest.Service;

import messagesApiRest.Domain.Label;

import messagesApiRest.Domain.Message;
import messagesApiRest.Repository.LabelRepository;
import messagesApiRest.Repository.MessageRepository;
import messagesApiRest.Security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class LabelServiceImpl implements ILabelService {

    LabelRepository labelRepository;
    MessageRepository messageRepository;


    @Autowired
    public LabelServiceImpl(LabelRepository labelRepository, MessageRepository messageRepository) {
        this.labelRepository = labelRepository;
        this.messageRepository = messageRepository;

    }

    public LabelServiceImpl(LabelRepository labelRepository) {
    }


    @Override
    public Label createLabel( Label label) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails) {
            Label labelEmail = new Label();
            labelEmail.setLabelName(label.getLabelName());
            return labelRepository.save(labelEmail);
        }
        return label;

    }

    @Override
    public Label editLabel(String labelName, Label label) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails) {
            Label labelValue = new Label();
            labelValue.setLabelName(label.getLabelName());
            return labelRepository.save(labelValue);
        }
        return label;
    }


    @Override
    public String removeLabel(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails) {
             labelRepository.deleteById(id);
            return "Label removed";

        }
        return "unauthorized";
    }

    @Override
    public Object addLabel(Long labelId, Long messageId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails) {

            Optional<Label> labelOptional = labelRepository.findById(labelId);
            Optional<Message> messageOptional = messageRepository.findById(messageId);
            Message messages = messageOptional.get();
            Label labels = labelOptional.get();
            messages.setLabel(labels);
            messageRepository.save(messages);

            return "label added";
        }
        return "Unauthorized" ;
    }



}
