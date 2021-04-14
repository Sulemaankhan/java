package ola.com.booking.service;

import java.util.List;

import ola.com.booking.model.Ride;

public interface RideService {

	public void booked(Ride ride);

	public List<Ride> getRides();

}
