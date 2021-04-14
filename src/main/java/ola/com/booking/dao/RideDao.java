package ola.com.booking.dao;

import java.util.List;

import ola.com.booking.model.Ride;


public interface RideDao {
	public void booked(Ride ride);
	public List<Ride> getRides();
}
