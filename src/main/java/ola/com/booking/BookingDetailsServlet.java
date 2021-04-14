package ola.com.booking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ola.com.booking.service.RideService;
import ola.com.booking.service.impl.RideServiceImpl;

@WebServlet("/ridedetails")
public class BookingDetailsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RideService rideService = new RideServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//after fatching all rides details from db store into req param.
		req.setAttribute("rideList", rideService.getRides()); // get all info like rideId,userId,RouteId and Date
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/bookingdetails.jsp");
		rd.include(req, resp);
	}// doPost() close
}// class
