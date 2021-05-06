package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoggedInServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		//- (request).getSession(boolean create) 
		// -When create == false if session doesn't exist, the one won't be created 
		HttpSession session = request.getSession(false);
		
		PrintWriter pw = response.getWriter();
		
		if(session != null) {
			pw.write("<div style='color:red;'> Welcome!"+session.getAttribute("username")+" </div>");
		} else {
			pw.write("<div style='color:red;'> You are not logged in! </div>");
		}
	}
}
