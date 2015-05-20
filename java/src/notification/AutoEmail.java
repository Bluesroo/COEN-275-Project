package notification;

import java.util.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * @author Mugen on 5/16/15.
 *
 * Modified from http://crunchify.com/java-mailapi-example-send-an-email-via-gmail-smtp/
 */
public class AutoEmail {

    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;

    public static void main(String args[]) throws AddressException, MessagingException {
        generateAndSendEmail();
        System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
    }

    public static void generateAndSendEmail() throws AddressException, MessagingException {

//Step1 -- Sends message via TLS
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties have been setup successfully..");

//Step2 -- Create Session and message (Recipients, subject, text)
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        // @TODO Need to get email recipients from the customer database
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("david.obatake@gmail.com"));
        generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("jpariseau101@gmail.com"));
        // @TODO need to check what the email message should be -- May need to include the invoice as an attachment
        generateMailMessage.setSubject("Your repair is ready for pickup");
        String emailBody = "Test email by JavaMail API example. " + "<br><br> Regards, <br>David";
        generateMailMessage.setContent(emailBody, "text/html");
        System.out.println("Mail Session has been created successfully..");

//Step3 -- Use Session var to get transport protocol and send message via the smtp server
        System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = getMailSession.getTransport("smtp");
        // @TODO need to figure out how we can input this and not save it as plain text
        transport.connect("smtp.gmail.com", "shohei741@gmail.com", "xxxx");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }

}
