package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Order;
import models.User;
import services.OrderService;

@WebServlet("/returns")
public class ReturnServlet extends HttpServlet {

	/**
	 * Servlet for Order Return Processing
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
				
		if(user != null) {	
			List<Order> orders = OrderService.listReturnRequestedOrders();
			req.setAttribute("orders", orders);
			
			req.getRequestDispatcher("/app/return/index.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("/");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
