package com.toursandtravels.Services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.toursandtravels.dto.ApiResponse;

public interface DocsAndImagesHandlingService {
	ApiResponse uploadPassangerGovernmentIdImage(Integer passengerId,MultipartFile imageFile) throws IOException;
	byte[] getPassengerGovernmentIdImage(Integer passengerId) throws IOException;
	
}
