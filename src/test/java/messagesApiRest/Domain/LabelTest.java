package messagesApiRest.Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.web.ServletTestExecutionListener;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LabelTest {

    private  Label label;


    @BeforeEach
    public void setUp(){
        label = new Label();

    }

    @Test
    void testGetId() {
        Long id = 1L;
        label.setId(id);
        assertEquals(id, label.getId());
    }

    @Test
    void testGetLabelName() {

        String name = "important";

        label.setLabelName(name);
        assertEquals(name, label.getLabelName());
    }

    @Test
    void testGetMessage() {
        Set<Message> messageSet = new HashSet<>();
        label.setMessage(messageSet);
        assertEquals(messageSet,label.getMessage());

    }

    @Test
    void testSetId() {
        Long idValue = 4L;
        Label labels = new Label();
        labels.setId(idValue);
        assertEquals(labels.getId(), idValue);

    }

    @Test
    void setLabelName() {
        String name = "important";
        Label labels = new Label();
        labels.setLabelName(name);
        assertEquals(labels.getLabelName(), name);

    }

    @Test
    void testSetMessage() {
        Set<Message> messageSet = new HashSet<>();
        Label labels = new Label();
        labels.setMessage(messageSet);
        assertEquals(labels.getMessage(), messageSet);
    }
}