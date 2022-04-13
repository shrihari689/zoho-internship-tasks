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
import javax.servlet.http.HttpSession;

import models.User;
import services.UserService;

@WebFilter("/app/*")
public class AuthFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession session = httpRequest.getSession();
		
		if((session != null) && (session.getAttribute("user") != null)) {
			User user = UserService.findById(((User) session.getAttribute("user")).getId());
			if(user != null) {				
				httpRequest.setAttribute("user", user);
			}
			chain.doFilter(httpRequest, httpResponse);
		} else {
			httpResponse.sendRedirect("/login");
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	
}
