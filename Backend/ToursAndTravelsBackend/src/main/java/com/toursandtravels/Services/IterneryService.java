package com.toursandtravels.Services;

import java.util.List;

import com.toursandtravels.dto.ApiResponse;
import com.toursandtravels.entities.Iternery;

public interface IterneryService {
	List<Iternery> getAllIternery();
	Iternery addIternery(Iternery iternery);
	Iternery updateIternery(Iternery iternery);
	ApiResponse deleteIternery(int iterneryId);
}
