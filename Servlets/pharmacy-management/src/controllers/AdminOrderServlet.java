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

@WebServlet({"/app/admin/orders", "/app/admin/orders/*"})
public class AdminOrderServlet extends HttpServlet {

	
	/**
	 * Servlet for managing the Orders in Admin View
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");

		String path = req.getRequestURI();
		
		if((user != null) && user.isAdmin()) {
			
			if(path.endsWith("/completed")) {
				List<Order> orders = OrderService.findByStatus(OrderStatus.COMPLETED);
				req.setAttribute("orders", orders);
				req.getRequestDispatcher("/app/admin/order/completed.jsp").forward(req, resp);	
			} else if(path.endsWith("/cancelled")) {
				List<Order> orders = OrderService.findByStatus(OrderStatus.CANCELLED);
				req.setAttribute("orders", orders);
				req.getRequestDispatcher("/app/admin/order/cancelled.jsp").forward(req, resp);
			} else {				
				List<Order> orders = OrderService.findByStatus(OrderStatus.PENDING);
				req.setAttribute("orders", orders);
				req.getRequestDispatcher("/app/admin/order/index.jsp").forward(req, resp);			
			}
			
		} else {
			resp.sendRedirect("/");
		}
		
	}
	
}
