package messagesApiRest.Service;

import messagesApiRest.Domain.Label;
import messagesApiRest.Domain.Message;
import messagesApiRest.Repository.LabelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import java.util.HashSet;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
class LabelServiceImplTest {

    @InjectMocks
    LabelServiceImpl labelService;

    @Mock
    LabelRepository labelRepository;




    @BeforeEach
    void setUp() {

        labelService = new LabelServiceImpl(labelRepository);
    }


    @Test
    void testCreateLabel() {

        Set<Message> messageSet = new HashSet<>();
        Label label = new Label(1L,"important", messageSet );;
        Label created = labelService.createLabel(label);
        verify(labelRepository, times(1)).save(label);


    }

    @Test
    @Disabled
    void testEditLabel() {
    }

    @Test
    @Disabled
    void testRemoveLabel() {




      }


    @Test
    @Disabled
    void testAddLabel() {


    }
}