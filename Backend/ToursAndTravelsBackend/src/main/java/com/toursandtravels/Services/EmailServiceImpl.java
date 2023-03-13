package com.toursandtravels.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toursandtravels.Repositories.AdminRepository;
import com.toursandtravels.Repositories.CustomerRepository;
import com.toursandtravels.entities.Admin;
import com.toursandtravels.entities.Customer;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private com.toursandtravels.Repositories.CredentialRepository credRepo;
	
	@Autowired
	private com.toursandtravels.Repositories.OTPRepository oTPRepo;
	
	@Override
	public SimpleMailMessage sendPasswordChangeOTPMail(String userName) {
		com.toursandtravels.entities.UserCredential role = credRepo.findById(userName).orElseThrow(()-> new com.toursandtravels.custom_exceptions.ResourceNotFoundException("Invalid User Name"));
		String otp = com.toursandtravels.entities.OTPGenerator.OTP();
		com.toursandtravels.entities.OTP otpData = new com.toursandtravels.entities.OTP(userName,otp);
		oTPRepo.save(otpData);
		SimpleMailMessage mesg = new SimpleMailMessage();
		if(role.getUserRole().toString().equalsIgnoreCase("ROLE_CUSTOMER")) {
			Customer cust = custRepo.findByCustomerCredentialsUserName(userName).orElseThrow(()-> new com.toursandtravels.custom_exceptions.ResourceNotFoundException("Invalid User Name"));
					mesg.setTo(cust.getEmail());
					mesg.setSubject("OTP for password change request");
					mesg.setText(com.toursandtravels.Repositories.EmailMessageRepository.passwordChangeOTPEmail(cust.getFirstname()+""+cust.getLastname()+""+cust.getFirstname(),otp));
			return mesg;
		}else {
			Admin admin = adminRepo.findByAdminCredentialsUserName(userName).orElseThrow(()-> new com.toursandtravels.custom_exceptions.ResourceNotFoundException("Invalid User Name"));
			mesg.setTo(admin.getEmail());
			mesg.setSubject("OTP for password change request");
		 mesg.setText(com.toursandtravels.Repositories.EmailMessageRepository.passwordChangeOTPEmail(admin.getFirstname()+" "+admin.getLastname()+" "+admin.getFirstname(),otp));
		 return mesg;
		}
	}

	

}
