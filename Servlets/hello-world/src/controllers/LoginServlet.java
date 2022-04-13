package controllers;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
import services.UserService;



@WebServlet({"/", "/auth", "/auth/login", "/auth/logout"})
public class LoginServlet extends HTTPMethodServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session != null) {
			Iterator<String> names = session.getAttributeNames().asIterator();
			while(names.hasNext()) {
				session.removeAttribute(names.next());
			}
			resp.sendRedirect("/");					
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		if(!req.getRequestURI().equalsIgnoreCase("/auth/login")) {
			resp.sendRedirect("/auth/login");
		} else {			
			req.getRequestDispatcher("/auth/login.jsp").forward(req, resp);	
		}
			
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		try {
			
			User user = UserService.findByUsernameAndPassword(username, password);

			if(user != null) {
				HttpSession session = req.getSession();
				if(session != null) {
					session.setAttribute("user", user);
					resp.sendRedirect("/app/home");					
				} else {
					req.setAttribute("errorMessage", "Unable to create a session");
				}
				return;
			} else {
				req.setAttribute("errorMessage", "Invalid Username / Password!");
			}
		} catch (SQLException e) {
			req.setAttribute("errorMessage", "Something went wrong!");
		} catch (IllegalArgumentException e) {			
			req.setAttribute("errorMessage", e.getMessage());
		}
		
		req.getRequestDispatcher("/auth/login.jsp").forward(req, resp);
				
	}
	
	
}
