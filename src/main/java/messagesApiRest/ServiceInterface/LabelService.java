package messagesApiRest.ServiceInterface;

import messagesApiRest.Domain.Label;
import messagesApiRest.Domain.Message;

public interface LabelService {

    Label createLabel(Label label);
    Label editLabel(String labelName, Label label);
    String removeLabel(String labelName);
    void addLabel(Label label);

}
