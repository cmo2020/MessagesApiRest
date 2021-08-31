package messagesApiRest.Service;

import messagesApiRest.Domain.Label;
import messagesApiRest.Repository.LabelRepository;
import messagesApiRest.Repository.MessageRepository;
import messagesApiRest.ServiceInterface.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements ILabelService {

    LabelRepository labelRepository;
    MessageRepository messageRepository;

    @Autowired
    public LabelServiceImpl(LabelRepository labelRepository, MessageRepository messageRepository) {
        this.labelRepository = labelRepository;
        this.messageRepository = messageRepository;
    }



    @Override
    public Label createLabel( Label label) {
        return labelRepository.save(label);
    }

    @Override
    public Label editLabel(String labelName, Label label) {
        Label labelValue = new Label();
        labelValue.setLabelName(label.getLabelName());
        return labelRepository.save(labelValue);
    }

    @Override
    public String removeLabel(String labelName) {
        return labelRepository.deleteByLabelName(labelName);
    }




    }
