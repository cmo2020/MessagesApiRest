package messagesApiRest.Service;

import messagesApiRest.Domain.Label;
import messagesApiRest.Domain.Message;
import messagesApiRest.Repository.LabelRepository;
import messagesApiRest.Repository.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class MessageServiceImplTest {

    @InjectMocks
    MessageServiceImpl messageService;
    @Mock
    MessageRepository messageRepository;
    @Mock
    LabelRepository labelRepository;
    @Mock
    Pageable pageable;


    @BeforeEach
    void setUp() {
        messageService = new MessageServiceImpl(messageRepository, labelRepository);
    }

    @Test
    void createMessage() {

        Message newMessage = new Message();
        Message messageCreated = messageService.createMessage(newMessage);
        verify(messageRepository, times(1)).save(newMessage);



    }


    @Test
    void deleteMessage() {

        Long idToDelete = 1L;

        String result =  messageService.deleteMessage(idToDelete);

        verify(messageRepository, times(1)).deleteById(anyLong());

        assertThat(result).isEqualTo("Message removed");

    }
}