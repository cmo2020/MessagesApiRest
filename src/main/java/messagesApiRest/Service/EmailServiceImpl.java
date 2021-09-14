package messagesApiRest.Service;

import messagesApiRest.Domain.Bcc;
import messagesApiRest.Domain.Cc;
import messagesApiRest.Domain.Message;
import messagesApiRest.Domain.Recipients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements IEmailService {

    private static final String EMAIL_ADDRESS = "corina.oyarzabal@globant.com";

    private JavaMailSender emailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(Message message, Recipients recipients, Cc cc, Bcc bcc) {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom(EMAIL_ADDRESS);
            msg.setTo(recipients.getRecipientOne());
            msg.setCc(cc.getCcOne());
            msg.setBcc(bcc.getBccOne());
            msg.setSubject(message.getSubject());
            msg.setText(message.getBody());

            emailSender.send(msg);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public void sendMessageWithAttachment(Message message, Recipients recipients) {
        try {
            MimeMessage msg = emailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(msg, true);

            helper.setFrom(EMAIL_ADDRESS);
            helper.setTo(recipients.getRecipientOne());
            helper.setSubject(message.getSubject());
            helper.setText(message.getBody());

            helper.addAttachment("hero.jpg", new ClassPathResource("hero.jpg"));

            emailSender.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}