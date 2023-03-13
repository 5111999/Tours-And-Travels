package com.toursandtravels.Services;

import org.springframework.mail.SimpleMailMessage;



public interface EmailService {
	SimpleMailMessage sendPasswordChangeOTPMail(String userName);
	
}
