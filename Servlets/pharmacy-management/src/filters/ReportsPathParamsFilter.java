package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Order;
import models.Report;
import models.User;
import services.OrderService;
import services.ReportService;

@WebFilter({"/reports/*"})
public class ReportsPathParamsFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		User user = (User) req.getSession().getAttribute("user");
		String pathInfo = req.getPathInfo();
		if(user != null) {
			if((pathInfo == null) || pathInfo.equals("/")) {
				chain.doFilter(request, response);
			} else {
				int id = Integer.parseInt(pathInfo.replace("/", ""));
				Report report = ReportService.findById(id);
				if(report != null) {				
					req.setAttribute("report", report);
					chain.doFilter(req, resp);
				} else {
					resp.sendRedirect("/");
				}
			}
			
		} else {
			resp.sendRedirect("/");
		}
			
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
