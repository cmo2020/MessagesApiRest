package messagesApiRest.Service;

import messagesApiRest.Domain.Label;


public interface ILabelService {

    Label createLabel(Label label);

    Label editLabel(String labelName, Label label);

    String removeLabel(Long id);

    Object addLabel(Long labelId, Long messageId);








}
