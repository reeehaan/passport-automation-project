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
                "<title>Passport Appointment Receipt</title>\n" +
                "<style>\n" +
                "    body {\n" +
                "        font-family: Arial, sans-serif;\n" +
                "        margin: 0;\n" +
                "        padding: 0;\n" +
                "        background-color: #f4f4f4;\n" +
                "    }\n" +
                "    .container {\n" +
                "        max-width: 600px;\n" +
                "        margin: 20px auto;\n" +
                "        padding: 20px;\n" +
                "        background-color: #fff;\n" +
                "        border-radius: 8px;\n" +
                "        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
                "    }\n" +
                "    h1, p {\n" +
                "        margin: 0;\n" +
                "        padding: 0;\n" +
                "    }\n" +
                "    .receipt-info {\n" +
                "        margin-bottom: 20px;\n" +
                "    }\n" +
                "    .receipt-info h2 {\n" +
                "        color: #00C2FF;\n" +
                "    }\n" +
                "    .receipt-details {\n" +
                "        background-color: #f9f9f9;\n" +
                "        padding: 10px 20px;\n" +
                "        border-radius: 5px;\n" +
                "    }\n" +
                "    .receipt-details p {\n" +
                "        margin: 5px 0;\n" +
                "    }\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container\">\n" +
                "    <div class=\"receipt-info\">\n" +
                "        <h2>Passport Appointment Schedule</h2>\n" +
                "        <p>You can only change  your appointment details only 3 Times:</p>\n" +
                "    </div>\n" +
                "    <div class=\"receipt-details\">\n" +
                "        <p><strong>Application ID:</strong> "+id+"</p>\n" +
                "        <p><strong>Date:</strong> "+date+"</p>\n" +
                "        <p><strong>Time:</strong> "+time+"</p>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>\n";
    }

}
