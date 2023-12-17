package com.marketingapp.util;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	
	@Autowired
	private JavaMailSender sender;
	
	public void sendEmail(String to, String subject, String body) {
	SimpleMailMessage message=new SimpleMailMessage();
	message.setTo(to);
	message.setSubject(subject);
	message.setText(body);
	
	sender.send(message);
	}

}
