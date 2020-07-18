package com.org.pimentorbackend.util.template;

import org.springframework.stereotype.Component;
import org.stringtemplate.v4.ST;

@Component
public class SmsTemplates {
	private ST smsverificationTemplete  
				= new ST("Your OTP for: Pimentor Mobile verification, <otp>");
	
	public String getSMSverificationText(String otp) {		
		smsverificationTemplete.add("otp", otp);
		return smsverificationTemplete.render();
	}
}
