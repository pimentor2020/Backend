package com.org.pimentorbackend.service.communicator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.org.pimentorbackend.util.PimentorConstants;
import com.org.pimentorbackend.util.RandomGenerator;
import com.org.pimentorbackend.util.template.SmsTemplates;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

/*
 * SMS service for 
 * 1) sending OTP for phone no. verification
 * 2) for interview reminder to interviewer and Aspirant
 * 3) For promotional purposes. 
 */
@Component
class SmsService implements Communicator{
	@Value("${twilio.sms.ACCOUNT_SID}")
    private String ACCOUNT_SID;
	@Value("${twilio.sms.AUTH_TOKEN}")
	private String AUTH_TOKEN;
	@Value("${twilio.sms.TWILIO_SENDER_NO}")
	private String senderNo;

	@Autowired
	RandomGenerator randomgen;
	@Autowired
	SmsTemplates smsTemplates;
	
	public String sendSMS(String smstype, String contactNo) {
		String generatedOTP = "-1";
		if (smstype.equals(PimentorConstants.SMSTYPE_VERIFICATION)) {
			generatedOTP = randomgen.getRandomValue();
			smsTemplates.getSMSverificationText(generatedOTP);
			List<String> list = new ArrayList<String>();
			list.add(generatedOTP);
			list.add(contactNo);
			send(list);
		} else if(smstype.equals(PimentorConstants.SMSTYPE_REMINDER)) {
			//need to add REMINDER template
		} else if(smstype.equals(PimentorConstants.SMSTYPE_PROMOTIONAL)) {
			//need to add PROMOTIONAL template
		}
		return generatedOTP;
	}
    
    public String send(List<String> details) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(details.get(0)), 
                new com.twilio.type.PhoneNumber(senderNo), details.get(1)).create();
        return message.getSid();
    }
}
