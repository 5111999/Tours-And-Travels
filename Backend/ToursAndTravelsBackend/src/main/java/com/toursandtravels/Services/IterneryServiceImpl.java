package com.toursandtravels.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toursandtravels.Repositories.IterneryRepository;
import com.toursandtravels.dto.ApiResponse;
import com.toursandtravels.entities.Iternery;

@Service
@Transactional
public class IterneryServiceImpl implements IterneryService {

	@Autowired
	private IterneryRepository iternaryRepo;
	
	@Override
	public List<Iternery> getAllIternery() {
		// TODO Auto-generated method stub
		return iternaryRepo.findAll();
	}

	@Override
	public Iternery addIternery(Iternery iternery) {
		// TODO Auto-generated method stub
		return iternaryRepo.save(iternery);
	}

	@Override
	public Iternery updateIternery(Iternery iternery) {
		// TODO Auto-generated method stub
		return iternaryRepo.save(iternery);
	}

	@Override
	public ApiResponse deleteIternery(int iterneryId) {
		// TODO Auto-generated method stub
		iternaryRepo.deleteById(iterneryId);
		return new ApiResponse("deleted Sucessfully");
	}
	


}
