package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Order;
import models.OrderStatus;
import models.User;
import services.OrderService;

@WebServlet({"/app/admin/returns", "/app/admin/returns/*"})
public class AdminReturnServlet extends HttpServlet {

	/**
	 * Servlet for handling Return Processing in Admin View
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");

		String path = req.getRequestURI();
		
		if((user != null) && user.isAdmin()) {
			
			if(path.endsWith("/completed")) {
				List<Order> orders = OrderService.findByStatus(OrderStatus.RETURN_COMPLETED);
				req.setAttribute("orders", orders);
				req.getRequestDispatcher("/app/admin/return/completed.jsp").forward(req, resp);	
			} else if(path.endsWith("/declined")) {
				List<Order> orders = OrderService.findByStatus(OrderStatus.RETURN_DECLINED);
				req.setAttribute("orders", orders);
				req.getRequestDispatcher("/app/admin/return/declined.jsp").forward(req, resp);
			} else {				
				List<Order> orders = OrderService.findByStatus(OrderStatus.RETURN_REQUESTED);
				req.setAttribute("orders", orders);
				req.getRequestDispatcher("/app/admin/return/index.jsp").forward(req, resp);			
			}
			
		} else {
			resp.sendRedirect("/");
		}
		
	}
	
}
