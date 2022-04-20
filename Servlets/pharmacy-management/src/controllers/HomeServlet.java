package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Order;
import models.User;
import services.MedicineService;
import services.OrderService;

@WebServlet({"/", "/app"})
public class HomeServlet extends HttpServlet {

	/**
	 * Servlet Class for Serving the Home Page of the Application
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = (User) req.getSession().getAttribute("user");

		if((user != null) && user.isAdmin()) {			
			int todayCount = OrderService.todayOrdersCount();
			int pendingCount = OrderService.pendingOrdersCount();
			int outOfStockCount = MedicineService.outOfStockCount();
			double todayRevenue = OrderService.todayRevenue();
			int todayReturnCount = OrderService.todayReturnsCount();
			
			req.setAttribute("todayCount", todayCount);
			req.setAttribute("pendingCount", pendingCount);
			req.setAttribute("outOfStockCount", outOfStockCount);
			req.setAttribute("todayRevenue", todayRevenue);
			req.setAttribute("todayReturnCount", todayReturnCount);
			req.getRequestDispatcher("/app/admin/index.jsp").forward(req, resp);
		} else if(user != null) {
			int userId = user.getId();
			List<Order> orders = OrderService.listByUserId(userId, 0, 10);
			req.setAttribute("orders", orders);			
			req.getRequestDispatcher("/app/index.jsp").forward(req, resp);			
		} else {
			resp.sendRedirect("/");
		}
		
	}

}
