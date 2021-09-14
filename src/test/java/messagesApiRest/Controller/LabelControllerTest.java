package messagesApiRest.Controller;

import messagesApiRest.Domain.Label;
import messagesApiRest.Domain.Message;
import messagesApiRest.Service.LabelServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.mockito.Mockito.*;


import java.util.HashSet;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
class LabelControllerTest {

    @Mock
    private LabelServiceImpl labelService;

    @InjectMocks
    private LabelController labelController;

    @BeforeEach
    void setUp() {
        labelController = new LabelController(labelService);
    }

    @Test
    void testCreateLabel() {
        Set<Message> messageSet = new HashSet<>();
        Label label = new Label(1L,"important", messageSet );
        Object result = labelController.createLabel(label);

        verify(labelService, Mockito.times(1)).createLabel(label);

        assertThat(result).isEqualTo( "label saved");
    }



    @Test
    void testRemoveLabel() {

        String result = labelController.removeLabel(1L);

        verify(labelService, times(1)).removeLabel(1L);

        assertThat(result).isEqualTo("label removed");

    }

    @Test
    void testAddLabel() {

        ResponseEntity<Object> result = labelController.addLabel(1L, 2L);
        verify(labelService, times(1)).addLabel(1L, 2L);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}