package com.toursandtravels.Services;

import java.util.List;

import com.toursandtravels.dto.ApiResponse;
import com.toursandtravels.dto.PassengerDto;
import com.toursandtravels.entities.Passanger;

public interface PassengerService {

List<Passanger> getAllPassenger();

Passanger addPassenger(Passanger passen,int custId);

Passanger updatePassenger(PassengerDto passen,int id);

ApiResponse deletePassenger(int passengerid);




}