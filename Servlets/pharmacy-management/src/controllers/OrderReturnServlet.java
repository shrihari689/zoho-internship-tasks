package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Order;
import models.OrderStatus;
import models.User;
import services.OrderService;

@WebServlet({"/orders/return", "/orders/return/*"})
public class OrderReturnServlet extends HttpServlet {

	/**
	 * Servlet for handling Order Return from Customer
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
				
		if(user != null) {	
			List<Order> orders = OrderService.listReturnOrders();
			req.setAttribute("orders", orders);
			
			req.getRequestDispatcher("/app/order/return.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("/");
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		Order order = (Order) req.getAttribute("order");

		if(user.getId() == order.getUserId()) {
			if((order.getStatus() == OrderStatus.COMPLETED)) {						
				try {
					OrderService.updateStatus(order.getId(), OrderStatus.RETURN_REQUESTED);
				} catch (SQLException e) {}
			}
			resp.sendRedirect("/app");
		} else {
			resp.sendRedirect("/");
		}
	}
	
}
