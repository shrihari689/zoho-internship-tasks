package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Medicine;
import models.Offer;
import models.Order;
import models.User;
import services.MedicineService;
import services.OfferService;
import services.OrderService;

@WebServlet("/order/*")
public class OrderServlet extends HttpServlet {

	/**
	 * Servlet for handling Medicine Orders
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		if(pathInfo != null) {
			int id = Integer.parseInt(pathInfo.replace("/", ""));
			Medicine medicine =  MedicineService.findById(id);
			req.setAttribute("medicine", medicine);
			req.getRequestDispatcher("/app/order/index.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("/");
		}
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pathInfo = req.getPathInfo();
		
		if(pathInfo != null) {
			int id = Integer.parseInt(pathInfo.replace("/", ""));
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			Medicine medicine =  MedicineService.findById(id);
			User user = (User) req.getSession().getAttribute("user");
			req.setAttribute("medicine", medicine);
			
			try {

				if((medicine == null) || (user == null)) {
					resp.sendRedirect("/");
				} else if(quantity > medicine.getQuantity()) {
					throw new Exception("Quantity must be within " + medicine.getQuantity());
				} else {
					
					int userId = user.getId();
					int medicineId = medicine.getId();
					String medicineName = medicine.getName();
					double amount = medicine.getPrice() * quantity;
					
					Offer offer = OfferService.currentOffer();
					
					if(offer != null) {
						amount = quantity * (medicine.getPrice() - (medicine.getPrice() * offer.getDiscount() / 100));
					}
					
					Order order = new Order(userId, medicineId, medicineName, quantity, amount);
					
					OrderService.placeOrder(order);

					req.setAttribute("order", order);
					req.setAttribute("successMessage", "Order Successful! Delivery details will be sent shortly");
					req.getRequestDispatcher("/app/order/success.jsp").forward(req, resp);
				}
			} catch (SQLException e) {
				req.setAttribute("errorMessage", "Something went wrong!");
				req.getRequestDispatcher("/app/order/index.jsp").forward(req, resp);
			} catch (Exception e) {
				req.setAttribute("errorMessage", e.getMessage());
				req.getRequestDispatcher("/app/order/index.jsp").forward(req, resp);
			}
			

			
			
		} else {
			resp.sendRedirect("/");
		}
		
	}
	
}
