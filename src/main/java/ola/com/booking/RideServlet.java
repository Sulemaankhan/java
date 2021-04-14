package ola.com.booking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ola.com.booking.model.Ride;
import ola.com.booking.model.Route;
import ola.com.booking.service.RideService;
import ola.com.booking.service.impl.RideServiceImpl;

@WebServlet("/rides")
public class RideServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RideService rideService = new RideServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("action").equals("book")) {
			Ride ride = new Ride();

			// get routeId from the rList
			Route routeId = (Route) req.getAttribute("rList");
			int userId = (int) req.getAttribute("uid");

			ride.setUserId(userId);
			ride.setRouteId(routeId.getRouteId());
			ride.setDateTime(req.getParameter("date"));
			rideService.booked(ride);
			RequestDispatcher rd = req.getRequestDispatcher("ridedetails");
			rd.forward(req, resp);
		}//if
	}//doPost() close
}//class
