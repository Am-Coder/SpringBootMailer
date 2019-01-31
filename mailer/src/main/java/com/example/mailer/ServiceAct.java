package com.example.mailer;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class ServiceAct	{
	
	@Autowired
	JavaMailSender jms;
	

	
	public void sendMail (String to,String subject,String info,String attachment) throws AddressException, MessagingException, IOException
	{
		MimeMessage msg = jms.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg,true);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(info);
		
	    FileSystemResource file 
	      = new FileSystemResource(new File(attachment));

		
	    helper.addAttachment(file.getFilename(), file);
	    jms.send(msg);
	}
}
