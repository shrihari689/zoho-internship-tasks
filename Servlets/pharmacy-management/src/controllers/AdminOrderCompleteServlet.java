package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Order;
import models.OrderStatus;
import models.User;
import services.OrderService;

@WebServlet("/app/admin/orders/complete/*")
public class AdminOrderCompleteServlet extends HttpServlet {

	/**
	 * Servlet for completing the Order in Admin Portal
	 */
	private static final long serialVersionUID = 1L;

	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 	User user = (User) req.getSession().getAttribute("user");
			Order order = (Order) req.getAttribute("order");
			 
			if((user.isAdmin() || (user.getId() == order.getUserId()))) {
				if((order.getStatus() == OrderStatus.PENDING)) {						
					try {
						OrderService.updateStatus(order.getId(), OrderStatus.COMPLETED);
					} catch (SQLException e) {}
				}
				if(user.isAdmin()) {
					resp.sendRedirect("/app/admin/orders/pending");
				} else {
					resp.sendRedirect("/app");
				}
			} else {
				resp.sendRedirect("/");
			}
	
	}
	
}
