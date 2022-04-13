import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/app/add")
public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static int count = 0;

	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			
			resp.setContentType("text/html");
 
			resp.addHeader("API-Token", "Heheeeee! :D");
		
			
			PrintWriter out = resp.getWriter();
			
			req.setAttribute("first_name", req.getParameter("first_name"));
			
			out.println("<title>I am home page</title>");
			out.println("Input Received from the Client: " + req.getQueryString());
			out.println("<h1>Count:</h1> " + count++);
			
			if(count > 10) {
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("alert.jsp");
				dispatcher.forward(req, resp);
				
			}
			 
		 
		}
		
}
