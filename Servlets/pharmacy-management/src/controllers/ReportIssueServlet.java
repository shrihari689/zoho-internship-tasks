package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Message;
import models.Report;
import models.User;
import services.MessageService;
import services.ReportService;

@WebServlet({"/reports", "/reports/*"})
public class ReportIssueServlet extends HttpServlet {

	/**
	 * Servlet for handling Report Issues in Customer View
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		if((session != null)) {
			User user = (User) req.getSession().getAttribute("user");
			if(user != null) {
				int userId = user.getId();
				Report report = (Report) req.getAttribute("report");
				if(report != null) {
					List<Message> messages = MessageService.findMessagesFromReportId(report.getId());
					MessageService.markAllMessageAsRead(report.getId(), userId);
					req.setAttribute("messages", messages);
					req.setAttribute("userId", userId);
					req.getRequestDispatcher("/app/report/messages.jsp").forward(req, resp);
				} else {
					List<Report> reports = ReportService.listReportByUserId(userId, true);
					req.setAttribute("reports", reports);
					req.setAttribute("userId", userId);
					req.getRequestDispatcher("/app/report/index.jsp").forward(req, resp);
				}
			
			} else {
				resp.sendRedirect("/app");
			}
		} else {
			resp.sendRedirect("/app");
		}
	}

	
	
}
