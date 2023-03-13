package com.toursandtravels.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toursandtravels.Repositories.PackagesRepositories;
import com.toursandtravels.dto.ApiResponse;
import com.toursandtravels.entities.Packages;

@Service
@Transactional
public class PackagesServiceImpl implements PackageService {

	@Autowired
	private PackagesRepositories packagesRepo;

	@Override
	public List<Packages> getAllPackages() {
		// TODO Auto-generated method stub
		return packagesRepo.findAll();
	}

	@Override
	public Packages addPackages(Packages packages) {
		// TODO Auto-generated method stub
		return packagesRepo.save(packages);
	}

	@Override
	public Packages updatePackages(Packages packages) {
		// TODO Auto-generated method stub
		return packagesRepo.save(packages);
	}

	@Override
	public ApiResponse deletePackages(int packId) {
		packagesRepo.deleteById(packId);
		return new ApiResponse("deleted Sucessfully");
	}

}
