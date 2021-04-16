package ola.com.booking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ola.com.booking.model.User;
import ola.com.booking.model.UserDTO;
import ola.com.booking.service.UserService;
import ola.com.booking.service.impl.UserServiceImpl;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("action").equals("register")) {
			
			User user = new User();
			user.setName(req.getParameter("name"));
			user.setEmail(req.getParameter("email"));
			user.setPassword(req.getParameter("password"));
			user.setPhoneNo(req.getParameter("phoneNo"));

			userService.saveUser(user);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(req, resp);
		}

		if (req.getParameter("action").equals("login")) {
			UserDTO dto = null;
			dto=new UserDTO();
			HttpSession ses=null;
			String user = req.getParameter("username");
			String pass = req.getParameter("passowrd");
			dto = userService.validateUser(user, pass);
			
			int s = dto.getuserId();
			// instead of boolean get user object
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();

			if (dto != null) {// user obj null or not
				ses=req.getSession();
				ses.setAttribute("userId", s);
				RequestDispatcher rd = req.getRequestDispatcher("routes");
				// send userId also
				out.println("<font color='red'><b>Login SuccessFully</b></font>");
				rd.include(req, resp);
			} else {
				out.println("<font color='red'><b>You have entered incorrect password</b></font>");
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/index.html");
				rd.include(req, resp);
			}
		}

	}

}
