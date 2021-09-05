package messagesApiRest.Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    Message message;

    @BeforeEach
    public void setUp(){
        message = new Message();

    }

    @Test
    void testGetId() {

        Long idValue = 4L;
        message.setId(idValue);

        assertEquals(idValue, message.getId());
    }

    @Test
    void testGetDeriveFrom() {

        String deriveFrom = "one@gmail.com";

        message.setDeriveFrom(deriveFrom);
        assertEquals(deriveFrom, message.getDeriveFrom());
    }

    @Test
    void testGetSubject() {

        String subject = "Hello world";

        message.setSubject(subject);
        assertEquals(subject, message.getSubject());
    }

    @Test
    void testGetRecipient() {
        String recipient = "one@gmail.com";

        message.setRecipient(recipient);
        assertEquals(recipient, message.getRecipient());
    }

    @Test
    void testGetCc() {
        String cc = "one@gmail.com";

        message.setCc(cc);
        assertEquals(cc, message.getCc());
    }

    @Test
    void testGetBcc() {
        String bcc = "one@gmail.com";

        message.setBcc(bcc);
        assertEquals(bcc, message.getBcc());
    }

    @Test
    void testGetBody() {
        String body = "something";

        message.setBody(body);
        assertEquals(body, message.getBody());
    }

    @Test
    void testGetAttachment() {

        byte[] attachment = new byte [127];

        message.setAttachment(attachment);
        assertEquals(attachment, message.getAttachment());
    }

    @Test
    void getDate() {
        LocalDateTime date = LocalDateTime.now();

        message.setDate(date);
        assertEquals(date, message.getDate());
    }

    @Test
    void testGetLabel() {
        Label label = new Label();
        message.setLabel(label);
        assertEquals(label, message.getLabel());
    }

    @Test
    void testGetUser() {
        User user = new User();
        message.setUser(user);
        assertEquals(user, message.getUser());
    }


    @Test
    void testSetDeriveFrom() {
        String from = "one@gmail.com";
        Message instance = new Message();
        instance.setDeriveFrom(from);
        assertEquals(instance.getDeriveFrom(), from);
    }

    @Test
    void testSetSubject() {
        String subject = "subject";
        Message instance = new Message();
        instance.setSubject(subject);
        assertEquals(instance.getSubject(), subject);
    }

    @Test
    void testSetRecipient() {
        String to = "one@gmail.com";
        Message instance = new Message();
        instance.setRecipient(to);
        assertEquals(instance.getRecipient(), to);
    }

    @Test
    void testSetCc() {
        String cc = "one@gmail.com";
        Message instance = new Message();
        instance.setCc(cc);
        assertEquals(instance.getCc(), cc);
    }

    @Test
    void testSetBcc() {
        String bcc = "one@gmail.com";
        Message instance = new Message();
        instance.setBcc(bcc);
        assertEquals(instance.getBcc(), bcc);

    }

    @Test
    void testSetBody() {
        String body = "body";
        Message instance = new Message();
        instance.setBody(body);
        assertEquals(instance.getBody(), body);
    }

    @Test
    void testSetAttachment() {
        byte[] at = new byte [127];
        Message instance = new Message();
        instance.setAttachment(at);
        assertEquals(instance.getAttachment(), at);
    }

    @Test
    void testSetDate() {
        LocalDateTime date = LocalDateTime.now();
        Message instance = new Message();
        instance.setDate(date);
        assertEquals(instance.getDate(), date);
    }

    @Test
    void testSetLabel() {
        Label label = new Label();
        Message instance = new Message();
        instance.setLabel(label);
        assertEquals(instance.getLabel(), label);
    }

    @Test
    void testSetUser() {
        User user = new User();
        Message instance = new Message();
        instance.setUser(user);
        assertEquals(instance.getUser(), user);
    }
}