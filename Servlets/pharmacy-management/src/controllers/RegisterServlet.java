package controllers;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
import services.UserService;


@WebServlet("/auth/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/app/register.jsp");
		dispatcher.forward(req, resp);	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		try {
			
			User user = new User();
			user.setName(name);
			user.setUsername(username);
			user.setPassword(password);
			
			UserService.createNewUser(user);
			 
			HttpSession session = req.getSession();
			if(session != null) {
				session.setAttribute("user", user);
				resp.sendRedirect("/app");					
				return;
			} else {
				req.setAttribute("errorMessage", "Unable to create a session");
			}
				 
			 
		} catch (SQLException e) {
			if(e.getErrorCode() == 1062) {
				req.setAttribute("errorMessage", "You already have an account! Login with it");
			} else {
				req.setAttribute("errorMessage", "Something went wrong!");
			}
		} catch (IllegalArgumentException e) {			
			req.setAttribute("errorMessage", e.getMessage());
		}
		
		req.getRequestDispatcher("/app/register.jsp").forward(req, resp);
		
	}
	
}
