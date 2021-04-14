package ola.com.booking.service.impl;

import java.util.List;

import ola.com.booking.dao.RideDao;
import ola.com.booking.dao.impl.RideDaoImpl;
import ola.com.booking.helper.RideHelper;
import ola.com.booking.model.Ride;
import ola.com.booking.service.RideService;

public class RideServiceImpl implements RideService {
	RideDao dao = null;

	@Override
	public void booked(Ride ride) {
		dao = new RideDaoImpl();
		ride.setRideId(RideHelper.getIncrement());
		dao.booked(ride);
	}

	@Override
	public List<Ride> getRides() {
		dao = new RideDaoImpl();
		List<Ride> result = dao.getRides();
		return result;
	}

}
