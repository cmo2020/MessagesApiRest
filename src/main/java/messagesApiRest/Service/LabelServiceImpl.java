package messagesApiRest.Service;

import messagesApiRest.Domain.Label;
import messagesApiRest.Repository.LabelRepository;
import messagesApiRest.ServiceInterface.LabelService;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {

    LabelRepository labelRepository;

    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
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
