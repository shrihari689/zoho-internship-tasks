import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/app/note")
public class NoteServlet extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("Init is called");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		PrintWriter out = new PrintWriter(resp.getWriter());
		out.print("You asked me to remember: ");
		out.println(req.getSession().getAttribute("note"));
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();	
		
		if(req.getParameter("action").equalsIgnoreCase("Add Note")) {
			session.setAttribute("note", req.getParameter("note"));	
		} else if(req.getParameter("action").equalsIgnoreCase("Delete Note")) {
			session.removeAttribute("note");
		}
		
		resp.sendRedirect("/app/home");		
	}
	
	
}