package com.org.pimentorbackend.service.communicator;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;




/*
 * EMAIL service for 
 * 1) sending profile creation confirmation
 * 2) interview reminder to interviewer and Aspirant
 * 3) For promotional purposes. 
 */
@Service
public class EmailService implements Communicator {	
	
	@Value("${twilio.email.AUTH_TOKEN}")
	String auth_Token;

	@Value("${twilio.email.sender_email_id}")
	String senderEmailId;
	
	public String send(List<String> address) {
	    Email from = new Email(senderEmailId);
	    String subject = "Sending with SendGrid is Fun";
	    Email to = new Email(address.get(0));
	    Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid(auth_Token);
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	      
	    }	    
	    return "";
	}
}
