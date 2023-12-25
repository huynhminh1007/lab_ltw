package service;

import db.MailProperties;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class MailService {

    static Properties props;

    static {
        props = new Properties();

        props.put("mail.smtp.auth", MailProperties.auth);
        props.put("mail.smtp.starttls.enable", MailProperties.ssl);
        props.put("mail.smtp.host", MailProperties.host);
        props.put("mail.smtp.port", MailProperties.port);
    }

    public static boolean send(String to, String subject, String mes) {
        try {
            Session session = Session.getInstance(props,
                    new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(MailProperties.username, MailProperties.password);
                        }
                    });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MailProperties.username, "Web Bán Hàng"));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(mes);
            Transport.send(message);
            return true;
        } catch (MessagingException | UnsupportedEncodingException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        MailService.send(MailProperties.username, "Demo Send Mail", "Hello World");
    }
}
