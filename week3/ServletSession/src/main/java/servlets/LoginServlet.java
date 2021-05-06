package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		// This is bad practice
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter pw = response.getWriter();
		
		// Some kind of validation process
		if(username.equals("admin") && password.equals("password")){
			// returned in the response to the client as a cookie to be used for requests
			HttpSession session =request.getSession();
			session.setAttribute("uname", username);
			
			request.getRequestDispatcher("loggedIn").forward(request, response);
		}else {
			request.getRequestDispatcher("index.html").include(request, response);
			pw.write("<div style='color:red;'> Unable to login </div>");
		}
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
	}
}
