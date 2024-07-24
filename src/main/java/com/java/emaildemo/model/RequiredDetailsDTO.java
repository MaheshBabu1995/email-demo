package com.java.emaildemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RequiredDetails
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequiredDetailsDTO {
    private String toAddress;
    private String subject;
    private String body;

}