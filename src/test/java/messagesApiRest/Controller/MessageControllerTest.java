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
    private  User user;

    @Mock
    private  Message message;



    @BeforeEach
    void setUp() {
        messageController = new MessageController(messageService);
    }

    @Test
    void testCreateMessage() {

        ResponseEntity<Message> result = messageController.createMessage(message);
        verify(messageService,times(1)).createMessage(message);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);


    }

    @Test
    void testReceivedMessages() {

      when(messageController.receivedMessages(user,message,pageableMock)).thenReturn(user, message, pageableMock);
      Object result = messageController.receivedMessages(user, message,pageableMock);
      verify(messageService, times(1)).receivedMessages(user, message,pageableMock);



    }

    @Test
    void testSentMessages() {


        when(messageController.sentMessages(user,message,pageableMock)).thenReturn(user, message, pageableMock);
        Object result = messageController.sentMessages(user, message,pageableMock);
        verify(messageService, times(1)).sentMessages(user, message,pageableMock);



    }

    @Test
    void testFilterByLabel() {
            Long labelId = 1L;

        when(messageController.filterByLabel(message, labelId, pageableMock)).thenReturn(message, labelId, pageableMock);
        Object result = messageController.filterByLabel(message, labelId, pageableMock);
        verify(messageService, times(1)).filterByLabel(message, labelId, pageableMock);



    }

    @Test
    void testDeleteMessage(){
        Long id = 1L;
        String result =   messageController.deleteMessage(id);
        verify(messageService, times(1)).deleteMessage(id);
        assertThat(result).isEqualTo(null);

    }
}