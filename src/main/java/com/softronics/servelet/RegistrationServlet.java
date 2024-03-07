package com.softronics.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softronics.service.UserService;


public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String name=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		String uemail=request.getParameter("uemail");
		String uaddr=request.getParameter("uaddr");
		
		UserService userService=new UserService ();
		String status=userService.registration(name, upwd, uemail, uaddr);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<font color='red'size='6'>");
		out.println("<h1>");
		
		
		
		if (status.equals("Existed"))
		{
			out.println("existed Succesfully...");
		}
		if (status.equals("failure"));
		{
			out.println("Registred  failure");
			
		}
		out.println("</h1></font></center></body></html>");
		
	}

		
		
		
		
	}


