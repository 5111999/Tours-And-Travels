package com.toursandtravels.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toursandtravels.Repositories.BookingRepository;
import com.toursandtravels.Repositories.CustomerRepository;
import com.toursandtravels.Repositories.PassengerRepository;
import com.toursandtravels.dto.ApiResponse;
import com.toursandtravels.dto.PassengerDto;
import com.toursandtravels.entities.Booking;
import com.toursandtravels.entities.Customer;
import com.toursandtravels.entities.Passanger;


@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private BookingRepository bookRepo;
	
	@Autowired
	private ModelMapper mapper;


	@Override
	public List<Passanger> getAllPassenger(){
		return passengerRepo.findAll();
	}
	
	
	@Override 
	public Passanger addPassenger(Passanger passenger, int custId) {
		Customer cust = custRepo.findById(custId).get();
		System.out.println(custRepo.findById(custId).get());
		cust.addPassenger(passenger);
		Booking book = bookRepo.findById(cust.getBooking().getBooking_id()).get();
		System.out.println(book);
		book.addPassangers(passenger);
		return passengerRepo.save(passenger);
	}
	
	@Override
	public Passanger updatePassenger(PassengerDto passenger,int id) {
		Passanger passen = passengerRepo.findById(id).get();
		 passen.setFirstname(passenger.getFirstname());
		 passen.setAddress(passenger.getAddress());
		 passen.setLastname(passenger.getLastname());
		 passen.setGender(passenger.getGender());
		 passen.setPassport(passenger.getPassport());
		
		return passengerRepo.save(passen);
//		return null;
	}
	

	@Override
	public ApiResponse deletePassenger(int passen) {
		// TODO Auto-generated method stub
		passengerRepo.deleteById(passen);
		return new ApiResponse("Deleted Sucessfully");
	}
}
