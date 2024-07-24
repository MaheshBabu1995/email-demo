package com.java.emaildemo.service;

import com.java.emaildemo.model.RequiredDetailsDTO;

/**
 * EmailService
 */
public interface EmailService {
//   public String sendEmail(RequiredDetailsDTO requiredDetailsDTO);
   public void sendEmail(RequiredDetailsDTO requiredDetailsDTO);
    
}