package ola.com.booking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ola.com.booking.ConectionManager;
import ola.com.booking.dao.RideDao;
import ola.com.booking.model.Ride;

public class RideDaoImpl implements RideDao {
	Connection conn = ConectionManager.getConnection();

	@Override
	public void booked(Ride ride) {
		try {

			PreparedStatement stmt = conn
					.prepareStatement("insert into Ride (RideId, UserId, RouteId, datetime) values (?,?,?,?)");
			stmt.setInt(1, ride.getRideId());
			stmt.setInt(2, ride.getUserId());
			stmt.setInt(3, ride.getRouteId());
			stmt.setString(4, ride.getDateTime());

			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}// booked

	@Override
	public List<Ride> getRides() {
		List<Ride> rideList = new ArrayList<Ride>();
		try {
			ResultSet result = conn.createStatement().executeQuery("select * from ride");
			while (result.next()) {
				Ride ride = new Ride();
				ride.setRideId(result.getInt("rideId"));
				ride.setUserId(result.getInt("userId"));
				ride.setRouteId(result.getInt("routeId"));
				ride.setDateTime(result.getString("datetime"));
				rideList.add(ride);
			}
			return rideList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}// getRides()
}// class
