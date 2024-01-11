package com.group2.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Inside Logout Servlet doGet!");
		
		HttpSession session = req.getSession();
		
		// remove session on logout.
		session.removeAttribute("User");
		session.invalidate();
		
		// after logging out redirect back to index.
		resp.sendRedirect("index.html");		
	}

}
