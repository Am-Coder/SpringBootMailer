package com.example.mailer;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailController {
	
	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@Autowired
	ServiceAct sact;
	
	@RequestMapping(value="/")
	public ModelAndView begin(ModelAndView mv) {
		logger.info("Entered First Page");
		mv.setViewName("index.html");
		return mv;
	}
	
	@GetMapping(value="/SendMail")
	public String sendEmail(HttpServletRequest req) throws AddressException, MessagingException, IOException {
		sact.sendMail(req.getParameter("to"),req.getParameter("subject"),req.getParameter("content"),req.getParameter("attachment"));
		logger.info("Message Sent Successful");
		return "Send success";
	}
	

}
