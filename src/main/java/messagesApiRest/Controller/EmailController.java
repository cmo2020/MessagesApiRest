package messagesApiRest.Controller;


import messagesApiRest.Domain.Bcc;
import messagesApiRest.Domain.Cc;
import messagesApiRest.Domain.Message;
import messagesApiRest.Domain.Recipients;
import messagesApiRest.Service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class EmailController {

    private EmailServiceImpl emailService;

    @Autowired

    public EmailController(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMail(@RequestBody Message message, Recipients recipients, Cc cc, Bcc bcc) {
        emailService.sendSimpleMessage(message, recipients, cc, bcc);
        return new ResponseEntity<>("Email Sent successfully", HttpStatus.OK);
    }

    @PostMapping("/attachment")
    public ResponseEntity<String> sendAttachmentEmail(@RequestBody Message message, Recipients recipients) throws MessagingException {
        emailService.sendMessageWithAttachment(message, recipients);
        return new ResponseEntity<>("Attachment mail sent successfully", HttpStatus.OK);
    }
}

