package com.toursandtravels.Services;

import java.util.List;

import com.toursandtravels.dto.ApiResponse;
import com.toursandtravels.entities.Packages;

public interface PackageService {

	
	List<Packages> getAllPackages();
	Packages addPackages(Packages packages);
	Packages updatePackages(Packages packages);
	ApiResponse deletePackages(int packId);
}
