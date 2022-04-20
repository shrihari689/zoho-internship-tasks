package controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Offer;
import services.OfferService;
	
@WebServlet("/app/admin/offers/*")
public class AdminOfferServlet extends HttpServlet {

	/**
	 * Servlet for handling Offers in Admin Portal
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getRequestURI().endsWith("/add")) {
			Offer currentOffer;
			try {
				currentOffer = OfferService.currentOffer();
				if(currentOffer != null) {
					resp.sendRedirect("/app/admin/offers");
				} else {					
					req.getRequestDispatcher("/app/admin/offer/add.jsp").forward(req, resp);
				}
			} catch (SQLException e) {
				req.getRequestDispatcher("/app/admin/offer/add.jsp").forward(req, resp);
			}
		} else {			
			Offer currentOffer;
			try {
				currentOffer = OfferService.currentOffer();
				if(currentOffer != null) {
					req.setAttribute("currentOffer", currentOffer);					
				}
			} catch (SQLException e) {}
			req.getRequestDispatcher("/app/admin/offer/index.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getRequestURI().endsWith("/delete")) {
			doDelete(req, resp);
		} else {
			try {
				String name = req.getParameter("name");
				double discount = Double.parseDouble(req.getParameter("discount"));
				LocalDateTime startDateTime = LocalDateTime.parse(req.getParameter("offerStartTime"), DateTimeFormatter.ISO_DATE_TIME);
				LocalDateTime startEndTime = LocalDateTime.parse(req.getParameter("offerEndTime"), DateTimeFormatter.ISO_DATE_TIME);
				Timestamp startTime = Timestamp.valueOf(startDateTime);
				Timestamp endTime = Timestamp.valueOf(startEndTime);
				
				Offer offer = new Offer(name, discount, startTime, endTime);
				
				OfferService.updateOffer(offer);
				
				resp.sendRedirect("/app/admin/offers");
				
			} catch (DateTimeParseException e) {
				req.setAttribute("errorMessage", "The given dates are not valid");
				req.getRequestDispatcher("/app/admin/offer/add.jsp").forward(req, resp);
			} catch (Exception e) {
				req.setAttribute("errorMessage", e.getMessage());
				e.printStackTrace();
				req.getRequestDispatcher("/app/admin/offer/add.jsp").forward(req, resp);
			}
		}

		
	}
	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			OfferService.deleteOffer();
		} catch (SQLException e) {e.printStackTrace();}
		resp.sendRedirect("/app/admin/offers");
	
	}
	
}
