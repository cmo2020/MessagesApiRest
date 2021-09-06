package messagesApiRest.Controller;



import messagesApiRest.Domain.Message;
import messagesApiRest.Domain.User;

import messagesApiRest.Service.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("message")
public class MessageController {

    private final MessageServiceImpl messageService;

    @Autowired
    public MessageController(MessageServiceImpl messageService) {
        this.messageService = messageService;
    }



    @PostMapping("/createMessage")
    public  ResponseEntity<Message> createMessage(@RequestBody Message message){
        messageService.createMessage(message);
        return  new ResponseEntity<Message>(HttpStatus.CREATED);
    }

    @GetMapping("/receivedMessages")
    public Page<Message>  receivedMessages(User user, Message message, Pageable pageable){
      return messageService.receivedMessages(user, message, pageable);



    }

    @GetMapping("/sentMessages")
    public Page<Message> sentMessages(User user, Message message, Pageable pageable){
        return  messageService.sentMessages(user, message, pageable);
}

    @GetMapping("/filterByLabel")
    public Page<Message> filterByLabel (@RequestParam("idLabel") Message message, Long idLabel , Pageable pageable){
        return messageService.filterByLabel(message, idLabel, pageable);
    }

    @DeleteMapping("/delete")
    public String deleteMessage (@RequestParam("idMessage")Long id){
     return messageService.deleteMessage(id);

    }

}