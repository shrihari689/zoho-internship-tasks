package controllers;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HTTPMethodServlet extends HttpServlet {

		private static final long serialVersionUID = 1L;
		
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String requestMethod = req.getParameter("_method");
			
			if((requestMethod != null) && requestMethod.equalsIgnoreCase("DELETE")) {
				doDelete(req, resp);
			} else {
				super.service(req, resp);	
			}
			
		}
		
		@Override
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}
	
}
