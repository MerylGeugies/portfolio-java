package com.example.portfolio;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

public class EmailSender {
    public Response sendEmail(String subject, Content content) throws IOException {
        Email from = new Email("meryl@sfdadfsasd.nl");
        Email to = new Email("meryl@affddsaf.nl");

        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("");
        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        return sg.api(request);

    }
}
