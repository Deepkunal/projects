package com.contactUs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.contactUs.RequestDao;


@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		
		response.setContentType("jsp");
		PrintWriter out=response.getWriter();
		
		  String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        
	        
	        System.out.println("email.." + email);
	        System.out.println("password.." + password);
	        
	        
	        UserDao rd = new UserDao();
	        if (rd.isUser())
	        {
	        	
	        	 response.sendRedirect("dashboard.jsp");
	        	 System.out.println("success");
	            
	        }
	        else {
	        	System.out.println("login failed");
	        request.getRequestDispatcher("login.jsp").forward(request, response);
	        	
	        }
		
	}

}