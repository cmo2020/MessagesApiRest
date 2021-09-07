package messagesApiRest.Service;

import messagesApiRest.Domain.Label;


public interface ILabelService {

    Object createLabel(Label label);


    String removeLabel(Long id);

    Object addLabel(Long labelId, Long messageId);








}
