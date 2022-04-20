package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Medicine;
import services.MedicineService;

@WebServlet({"/app/admin/medicines", "/app/admin/medicines/*"})
public class MedicineServlet extends HttpServlet {
		
	/**
	 * Servlet for maintaining Medicine details
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getRequestURI().endsWith("/new")) {
			req.getRequestDispatcher("/app/admin/medicine/add.jsp").forward(req, resp);
		} else {
			String pathInfo = req.getPathInfo();

			if(pathInfo != null) {		
				try {
					int id = Integer.parseInt(pathInfo.replace("/", ""));
					Medicine medicine =  MedicineService.findById(id);
					if(medicine != null) {
						req.setAttribute("medicine", medicine);						
						req.getRequestDispatcher("/app/admin/medicine/edit.jsp").forward(req, resp);
						return;
					}
				} catch (Exception e) {}
			}

			List<Medicine> medicines = MedicineService.listAllMedicines(0, 20);
			req.setAttribute("medicines", medicines);
			req.getRequestDispatcher("/app/admin/medicine/index.jsp").forward(req, resp);
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		double price = Double.parseDouble(req.getParameter("price"));
		
		try {
			Medicine medicine = new Medicine(name, description, quantity, price);
			if(req.getRequestURI().endsWith("/update")) {
				int id = Integer.parseInt(req.getParameter("id"));
				medicine.setId(id);
				MedicineService.updateMedicine(medicine);
			} else {				
				MedicineService.createMedicine(medicine);				 
			}
			
		} catch (IllegalArgumentException e) {			
			req.setAttribute("errorMessage", e.getMessage());
		} catch (Exception e) {
			req.setAttribute("errorMessage", "Something went wrong!");
		}
		
		resp.sendRedirect("/app/medicines");
		
	}
	

}
