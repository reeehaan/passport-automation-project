package org.example.projectpassport;

import java.sql.SQLException;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class EmailSender {



    private final String email = "srilanakapassportdepartment@gmail.com";
    private final String password = "xlnatrctfllrlolo";

    private Properties emailSenderProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        return properties;
    }

    public void sendEmail(String receiveEmail,String id ,String date ,String time) {
        Session session = Session.getInstance(emailSenderProperties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(email));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiveEmail));

            String messageContent = emailLayout(id,date,time);
            msg.setSubject("Passport Appointment Date");
            msg.setContent(messageContent, "text/html");
            Transport.send(msg);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private  String emailLayout(String id ,String date ,String time){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "<title>Email Appointment Date</title>\n" +
                "<style>\n" +
                "  body {\n" +
                "    font-family: Arial, sans-serif;\n" +
                "    background-color: #f4f4f4;\n" +
                "    margin: 0;\n" +
                "    padding: 0;\n" +
                "  }\n" +
                "  .container {\n" +
                "    max-width: 600px;\n" +
                "    margin: 0 auto;\n" +
                "    padding: 20px;\n" +
                "    background-color: #ffffff;\n" +
                "    border-radius: 10px;\n" +
                "    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
                "  }\n" +
                "  h2 {\n" +
                "    color: #333333;\n" +
                "  }\n" +
                "  .appointment-details {\n" +
                "    margin-top: 20px;\n" +
                "  }\n" +
                "  .detail-label {\n" +
                "    font-weight: bold;\n" +
                "  }\n" +
                "  .detail-value {\n" +
                "    margin-bottom: 10px;\n" +
                "  }\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <div class=\"container\">\n" +
                "    <h2>Appointment Details</h2>\n" +
                "    <div class=\"appointment-details\">\n" +
                "      <p class=\"detail-label\">Your Application ID:</p>\n" +
                "      <p class=\"detail-value\">"+id+"</p>\n" +
                "      <p class=\"detail-label\">Time:</p>\n" +
                "      <p class=\"detail-value\">"+time+"</p>\n" +
                "      <p class=\"detail-label\">Date:</p>\n" +
                "      <p class=\"detail-value\">"+date+"</p>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</body>\n" +
                "</html>\n";
    }

}
