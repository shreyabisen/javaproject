package com.softronics.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softronics.service.UserService;


public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		
		UserService userService=new UserService();
	String status=	userService.checkLogin(uname, upwd);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<font color='red'size='6'>");
		out.println("<h1>");
		out.println("<success>");
		
		if (status.equals("sucess"))
		{
			out.println("Login Succesfully...");
		}
		if (status.equals("failure"));
		{
			out.println("login failure");
			
		}
		out.println("</h1></font></center></body></html>");
		
	}

}
