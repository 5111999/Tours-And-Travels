package com.toursandtravels.Services;

import com.toursandtravels.entities.OTP;

public interface OTPService {
	OTP getUserOTPbyUserName(String userName);
}
