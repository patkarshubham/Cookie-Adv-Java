import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class Logout extends HttpServlet{
    
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		//get cookie from client
	
		Cookie[] ck=req.getCookies();
		Cookie user=null;
		if(ck!=null) {
	       for(Cookie c:ck) {
	    	   if(c.getName().equals("email")) {
	    	   user=c;
	    	   break;
	       }
		}}
		if(user!=null) {
			user.setMaxAge(0);
			res.addCookie(user);
			
		}
		res.sendRedirect("index.html");
		
	}
}