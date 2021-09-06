package messagesApiRest.Controller;


import messagesApiRest.Domain.Message;
import messagesApiRest.Service.EmailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.mail.MessagingException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class EmailControllerTest {

    @Mock
    private EmailServiceImpl emailService;

    @InjectMocks
    private EmailController emailController;



    @BeforeEach
    void setUp() {
        emailController = new EmailController(emailService);
    }

    @Test
    void testSendMail() {
        Message message = new Message();
        ResponseEntity<String> result = emailController.sendMail(message);
        verify(emailService, times(1)).sendSimpleMessage(message);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void testSendAttachmentEmail() throws MessagingException {
        Message message = new Message();
        ResponseEntity<String> result = emailController.sendAttachmentEmail(message);
        verify(emailService, times(1)).sendMessageWithAttachment(message);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);

    }
}