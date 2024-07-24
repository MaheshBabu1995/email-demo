package com.java.emaildemo.service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.java.emaildemo.model.RequiredDetailsDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
//	public String sendEmail(RequiredDetailsDTO requiredDetailsDTO) {
	public void sendEmail(RequiredDetailsDTO requiredDetailsDTO) {
//		System.out.println("requiredDetailsDTO: " + requiredDetailsDTO);
//		MimeMessage message = javaMailSender.createMimeMessage();
		// message.setFrom(requiredDetailsDTO.getToAddress());
//		try {
//			message.setRecipients(MimeMessage.RecipientType.TO, requiredDetailsDTO.getToAddress());
//			message.setSubject(requiredDetailsDTO.getSubject());
//			String htmlContent = "<h1>This is a test Spring Boot email</h1>" + "<p>It can contain <strong>"
//					+ requiredDetailsDTO.getBody() + "</strong> content.</p>";
//			message.setContent(htmlContent, "text/html; charset=utf-8");
//			javaMailSender.send(message);
//			return "successfully sent";
//		} catch (MessagingException e) {
//			throw new RuntimeException(e.getLocalizedMessage());
//		}

		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom("haribabu9533@outlook.com", "hari");
			helper.setTo(requiredDetailsDTO.getToAddress());
			helper.setSubject(requiredDetailsDTO.getSubject());
			helper.setText(
					"<h1>This is a test Spring Boot email</h1><p>It can contain <strong> Hello body</strong> content.</p>",
					true);
			javaMailSender.send(message);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

//	public void sendHtmlEmail() throws MessagingException {
//		MimeMessage message = javaMailSender.createMimeMessage();
//
//		message.setFrom(new InternetAddress("sender@example.com"));
//		message.setRecipients(MimeMessage.RecipientType.TO, "recipient@example.com");
//		message.setSubject("Test email from Spring");
//
//		String htmlContent = "<h1>This is a test Spring Boot email</h1>"
//				+ "<p>It can contain <strong>HTML</strong> content.</p>";
//		message.setContent(htmlContent, "text/html; charset=utf-8");
//
//		javaMailSender.send(message);
//	}

}
