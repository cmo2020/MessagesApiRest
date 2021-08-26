package messagesApiRest.ServiceInterface;

import messagesApiRest.Domain.Label;

public interface LabelService {

    public Label createLabel(Label label);
    public Label editLabel(String labelName, Label label);
    public String removeLabel(String labelName);

}
