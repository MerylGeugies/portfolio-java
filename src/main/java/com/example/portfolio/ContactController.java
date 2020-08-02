package com.example.portfolio;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String contactform(Model model){
        return "contact";
    }

    @PostMapping("/contact")
    public String contactSubmit(@ModelAttribute Contact contact, Model model) throws IOException {
        if(contact.getEmail().isEmpty())
        {
            model.addAttribute("error", "Email mag niet leeg zijn");
            return "emailfailure";
        }

        EmailSender sender = new EmailSender();

        String subject = "Mail recieved from: " + contact.getName() + "(" + contact.getEmail() + ")";
        Content content = new Content("text/html", contact.getPhone() + "<br/>" + contact.getMessage());

        Response response = sender.sendEmail(subject,content);

        if(response.getStatusCode() > 399){
            model.addAttribute("error", response.getBody());
            return "emailfailure";
        }

        return "emailsucces";
    }

}
