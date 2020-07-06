package com.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

@Service
public class MailService {

	public void sendEmailForPassword(String email,String password) {
		System.out.println("email is"+email);
		Email from = new Email("admin@tifin.com");
		String subject = "Password Recovery";
		Email to = new Email(email);
		Content content = new Content("text/plain", "As Per your request we sent your password your password for login in tifin.com is "+password);
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid("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");
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
			ex.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new MailService().sendEmailForPassword("praharshdave36@gmail.com", "123123");
	}
}
