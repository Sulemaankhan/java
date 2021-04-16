package ola.com.booking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ola.com.booking.model.Ride;
import ola.com.booking.model.Route;
import ola.com.booking.service.RideService;
import ola.com.booking.service.impl.RideServiceImpl;

@WebServlet("/Ride")
public class RideServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RideService rideService = new RideServiceImpl();
	HttpSession ses = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ses = req.getSession();
		if (req.getParameter("action").equals("book")) {
			Ride ride = new Ride();

			int uid = (int) ses.getAttribute("userId");
			ride.setUserId(uid);
			ride.setRouteId(Integer.parseInt(req.getParameter("routeId")));
			java.util.Date date = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			ride.setDateTime(sqlDate);

			rideService.booked(ride);
			req.setAttribute("rideList", rideService.getRides());
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/bookingdetails.jsp");
			rd.forward(req, resp);
		} // if
	}// doPost() close
}// class
