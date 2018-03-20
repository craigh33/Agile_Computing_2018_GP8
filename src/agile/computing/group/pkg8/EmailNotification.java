package agile.computing.group.pkg8;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author craig
 */
public class EmailNotification
{
  private static final String USER_NAME = "agilecomputing@mail.com";
  private static final String PASSWORD = "Agilegroup:8";
  
    /**
     *Constructor
     */
    public EmailNotification() {}
  
    /**
     * Used to Send Email
     *
     * @param subject
     * @param body
     * @param recipient
     */
    public void sendEmail(String subject, String body, String recipient)
  {
    String from = USER_NAME;
    String pass = PASSWORD;
    String[] to = { recipient };
    


    Properties props = System.getProperties();
    
    String host = "smtp.mail.com";
    //String host = "smtp-mail.outlook.com";//outlook Test
    
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.user", from);
    props.put("mail.smtp.password", pass);
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");
    
    Session session = Session.getDefaultInstance(props);
    MimeMessage message = new MimeMessage(session);
    try
    {
      message.setFrom(new InternetAddress(from));
      InternetAddress[] toAddress = new InternetAddress[to.length];
      

      for (int i = 0; i < to.length; i++) {
        toAddress[i] = new InternetAddress(to[i]);
      }
      
      for (int i = 0; i < toAddress.length; i++) {
        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
      }
      
      message.setSubject(subject);
      message.setText(body);
      Transport transport = session.getTransport("smtp");
      transport.connect(host, from, pass);
      transport.sendMessage(message, message.getAllRecipients());
      transport.close();
    }
    catch (AddressException ae) {
      ae.printStackTrace();
    }
    catch (MessagingException me) {
      me.printStackTrace();
    }
  }
}