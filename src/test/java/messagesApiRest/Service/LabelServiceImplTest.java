package messagesApiRest.Service;

import messagesApiRest.Domain.Label;
import messagesApiRest.Domain.Message;
import messagesApiRest.Repository.LabelRepository;
import messagesApiRest.Repository.MessageRepository;
import messagesApiRest.Security.CustomUserDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithUserDetails;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
class LabelServiceImplTest {

    @InjectMocks
    LabelServiceImpl labelService;

    @Mock
    LabelRepository labelRepository;

    @Mock
    MessageRepository messageRepository;
    @Mock
    Message message;



    @BeforeEach
    void setUp() {

        labelService = new LabelServiceImpl(messageRepository, labelRepository);
    }


    @Test

    void testCreateLabel() {

        Set<Message> messageSet = new HashSet<>();
        Label label = new Label(1L,"important", messageSet );

        Object created = labelService.createLabel(label);

        verify(labelRepository, times(1)).save(label);

        assertThat(created).isEqualTo("label saved");




    }


    @Test
    void testRemoveLabel() {
      Long idToDelete = 1L;

      String result =  labelService.removeLabel(idToDelete);

      verify(labelRepository, times(1)).deleteById(anyLong());

      assertThat(result).isEqualTo("Label removed");

      }



}