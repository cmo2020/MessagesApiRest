package messagesApiRest.Controller;

import messagesApiRest.Domain.Label;
import messagesApiRest.Domain.Message;
import messagesApiRest.Domain.User;
import messagesApiRest.Service.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {

    private final MessageServiceImpl messageService;

    @Autowired
    public MessageController(MessageServiceImpl messageService) {
        this.messageService = messageService;
    }


    @GetMapping("/listByLabel")
    public List<Message> filterByLabel(String labelName) {
      return   messageService.filterByLabel(labelName);

    }

    @PostMapping("/addLabel/{id}")
    public ResponseEntity<Message> addLabel(@RequestBody Label label, Long id){
        messageService.addLabel(label, id);
        return new ResponseEntity<Message>(HttpStatus.OK);

    }
    @PostMapping("/createMessage")
    public  ResponseEntity<Message> createMessage(@RequestBody Message message){
        messageService.createMessage(message);
        return  new ResponseEntity<Message>(HttpStatus.OK);
    }

    @GetMapping("/receivedMessages")
    public List<Message>  receivedMessages(User user, Message message){
        return  messageService.receivedMessages(user, message);

    }
}