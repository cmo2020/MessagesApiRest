package messagesApiRest.ServiceInterface;

import messagesApiRest.Domain.Label;
import messagesApiRest.Domain.Message;

public interface ILabelService {

    Label createLabel(Label label);
    Label editLabel(String labelName, Label label);
    String removeLabel(String labelName);


}
