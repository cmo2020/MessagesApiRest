package messagesApiRest.Controller;

import messagesApiRest.Domain.Message;
import messagesApiRest.Service.MessageServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {

    private final MessageServiceImpl messageService;

    public MessageController(MessageServiceImpl messageService) {
        this.messageService = messageService;
    }


    @GetMapping("/listByLabel")
    public List<Message> filterByLabel(String labelName) {
      return   messageService.filterByLabel(labelName);

    }
}