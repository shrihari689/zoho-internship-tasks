package controllers;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/auth/logout")
public class LogoutServlet extends HttpServlet {
	
	
	/**
	 * Logout Servlet for removing the session
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Iterator<String> names = session.getAttributeNames().asIterator();
		while(names.hasNext()) {
			session.removeAttribute(names.next());
		}
		
		resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);	
		resp.sendRedirect("/");
	}
	
}
