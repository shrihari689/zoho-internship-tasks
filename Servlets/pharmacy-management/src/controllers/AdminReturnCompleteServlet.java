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

@WebServlet("/app/admin/returns/complete/*")
public class AdminReturnCompleteServlet extends HttpServlet {

	/**
	 * Servlet for Handling Return Complete in Admin View
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		Order order = (Order) req.getAttribute("order");
		 
		if(user.isAdmin()) {
			if((order.getStatus() == OrderStatus.RETURN_REQUESTED)) {						
				try {
					OrderService.updateStatus(order.getId(), OrderStatus.RETURN_COMPLETED);
				} catch (SQLException e) {}
			}
			resp.sendRedirect("/app/admin/returns/pending");
		} else {
			resp.sendRedirect("/");
		}
	}

}
