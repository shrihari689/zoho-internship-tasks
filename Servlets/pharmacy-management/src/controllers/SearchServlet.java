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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	
	/**
	 * Servlet that handles Customer Medicine Search
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String searchQuery = req.getParameter("query");
		
		if((searchQuery == null) || (searchQuery.isBlank())) {
			resp.sendRedirect("/");
		} else {
			List<Medicine> medicines = MedicineService.searchMedicines(searchQuery, 0, 20);
			req.setAttribute("medicines", medicines);
			req.setAttribute("query", searchQuery);
			req.getRequestDispatcher("/app/search.jsp").forward(req, resp);
		}
		
	}
	
	
}
