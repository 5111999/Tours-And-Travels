package com.toursandtravels.Services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.toursandtravels.Repositories.PassengerRepository;
import com.toursandtravels.custom_exceptions.ResourceNotFoundException;
import com.toursandtravels.dto.ApiResponse;
import com.toursandtravels.entities.Passanger;

@Service
@Transactional
public class DocsAndImagesHandlingServiceImpl implements DocsAndImagesHandlingService {

	@Value("${customer.government.id.upload.folder}")
	private String passengerGovernmentIdFolder;


	@Autowired
	private PassengerRepository passRepo;

	@PostConstruct
	public void myInit() {
		System.out.println("in myInit " + passengerGovernmentIdFolder);
		// chk of folder exists --o.w create one!
		File passengerGovernmentPath = new File(passengerGovernmentIdFolder);

		if (!passengerGovernmentPath.exists()) {
			passengerGovernmentPath.mkdirs();
		} else {
			System.out.println("folders alrdy exists....");
		}

	}

	public ApiResponse uploadPassangerGovernmentIdImage(Integer passengerId, MultipartFile imageFile) throws IOException {
		Passanger passenger = passRepo.findById(passengerId)
				.orElseThrow(() -> new ResourceNotFoundException("InValid passenger Id !!!!!"));
		String targetPath = passengerGovernmentIdFolder + File.separator + "gi" + passenger.getPassengerid() + "."
				+ imageFile.getOriginalFilename().split("\\.")[1];
		System.out.println("Employee Profile Image Path : " + targetPath);
		Files.copy(imageFile.getInputStream(), Paths.get(targetPath), StandardCopyOption.REPLACE_EXISTING);
		passenger.setPassportPath(targetPath);
		return new ApiResponse("Government Id Uploaded Sucessfully !!!");
	}

	public byte[] getPassengerGovernmentIdImage(Integer passengerId) throws IOException {
		Passanger app = passRepo.findById(passengerId)
				.orElseThrow(() -> new ResourceNotFoundException("InValid Applicant ID"));
		String path = app.getPassportPath();
		if (path == null) {
			throw new ResourceNotFoundException("Image does Not Exists !!!!");
		}
		return Files.readAllBytes(Paths.get(path));
	}


}
