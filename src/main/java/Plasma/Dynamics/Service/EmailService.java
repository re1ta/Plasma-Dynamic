package Plasma.Dynamics.Service;

import org.springframework.beans.SimpleBeanInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.introspector.Property;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService  {

    public void sendEmailMessage(String text){
        Properties properties = new Properties();
        String from = "ernest.ibatov@mail.ru";
        String to = "thermalspray@mail.ru";
        properties.put("mail.smtp.host","smtp.mail.ru");
        properties.put("mail.smtp.post","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        Session session = Session.getInstance(
                properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,"aq0v7FZcZ7j5u5y4Fz20");
                    }
                }
        );
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipients(Message.RecipientType.TO, to);
            message.setSubject("Заявка");
            message.setText(text);
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
