import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
    public void sendGmail(final String reciever, final String sender, final String senderPassword,int testResult, int testCount,String id)
    {
        Properties mailProperties=new Properties();
        mailProperties.put("mail.smtp.host", "smtp.gmail.com");
        mailProperties.put("mail.smtp.port", "587");
        mailProperties.put("mail.smtp.auth" , "true");
        mailProperties.put("mail.smtp.starttls.enable", "true");

        Authenticator authenticator=new Authenticator(){protected PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication(sender,senderPassword);
        }
        };
        Session session=Session.getDefaultInstance(mailProperties,authenticator);
float percent=(testResult/testCount)*100;
        final MimeMessage message=new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(reciever));
            message.setSubject("Quiz Result");
            message.setText(String.format("Student with id %s took %.2f percent for quiz!",id,percent));
            Transport.send(message);
            System.out.println("message is sent");
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }

}
