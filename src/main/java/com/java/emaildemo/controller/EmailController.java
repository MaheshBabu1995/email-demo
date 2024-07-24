package com.java.emaildemo.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.emaildemo.model.RequiredDetailsDTO;
import com.java.emaildemo.service.EmailService;

@RestController
@RequestMapping(path = "api/v1/email")
public class EmailController {
	private static final Logger logger = Logger.getLogger(EmailController.class.getName());
	@Autowired
	private EmailService emailService;

	@GetMapping("msg")
	public ResponseEntity<String> getById() {
		return ResponseEntity.ok("Hello!");
	}

	@PostMapping("emaildata")
	public ResponseEntity<String> create(@RequestBody RequiredDetailsDTO item) {
		try {

			System.out.println("postman data: " + item);
			RequiredDetailsDTO savedItem = new RequiredDetailsDTO().builder().toAddress(item.getToAddress())
					.subject(item.getSubject()).body(item.getBody()).build();

			emailService.sendEmail(savedItem);
//			String s = emailService.sendEmail(savedItem);
//			logger.info(s + savedItem.toString());
//			return new ResponseEntity<>(s, HttpStatus.CREATED);
			return new ResponseEntity<>("success", HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException(e.getLocalizedMessage());
		}
	}

}
