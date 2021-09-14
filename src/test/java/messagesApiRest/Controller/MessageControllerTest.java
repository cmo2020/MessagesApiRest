package messagesApiRest.Controller;


import messagesApiRest.Domain.Message;

import messagesApiRest.Domain.User;
import messagesApiRest.Service.MessageServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessageControllerTest {

    @Mock
    private MessageServiceImpl messageService;

    @InjectMocks
    private MessageController messageController;

    @Mock
    private Pageable pageableMock;

    @Mock
    private Page<User> user;

    @Mock
    private  Page<Message> message;
    @Mock
     private PageImpl<Message> messagePage;

    @Mock
    private  User userNew;

    @Mock
    private Message messageNew;




    @BeforeEach
    void setUp() {
        messageController = new MessageController(messageService);
    }

    @Test
    void testCreateMessage() {

        ResponseEntity<Message> result = messageController.createMessage(messageNew);
        verify(messageService,times(1)).createMessage(messageNew);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);


    }

    @Test
    void testReceivedMessages() {


    }

    @Test
    void testSentMessages() {



    }

    @Test
    void testFilterByLabel() {
            Long labelId = 1L;



    }

    @Test
    void testDeleteMessage(){
        Long id = 1L;
        String result =   messageController.deleteMessage(id);
        verify(messageService, times(1)).deleteMessage(id);
        assertThat(result).isEqualTo(null);

    }
}