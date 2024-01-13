package com.group2.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group2.dao.DaoProxy;
import com.group2.services.ApplicationServices;
import com.group2.services.HtmlManager;
import com.group2.user.User;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// create instances of ApplicationDAO to manage CRUD operations
	ApplicationServices daoProxy = new DaoProxy();	// Added proxy pattern to access DAO
	
	// create instance of HtmlManager to write the html pages
	HtmlManager html = new HtmlManager();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Servlet for handling Record Lists
		System.out.println("Inside Profile Servlet doGet method");
		
		// manage sessions informations for access
		HttpSession session = req.getSession();
		if(session.getAttribute("User")==null) {
			resp.sendRedirect("login");
		}
		
		// retrieve user object from session.
		User user = (User) session.getAttribute("User");
		
		// Display html page from get request
		String page = html.getHTMLStringProfile(req.getServletContext().getRealPath("profile.html"), user);	
		resp.getWriter().write(page);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Servlet for handling Record Lists
		System.out.println("Inside Profile Servlet doPost method");
		
		// Manage sessions informations for access
		HttpSession session = req.getSession();
		if(session.getAttribute("User")==null) {
			resp.sendRedirect("login");
		}
		
		// Retrieve user object from session.
		User user = (User) session.getAttribute("User");
		
		// Retrieve From data
		String currentPassword = req.getParameter("current-password");
		String newPassword =  req.getParameter("new-password");
		String email =  req.getParameter("email");	
		
		// Retreive form function
		String formPurpose = req.getParameter("function");
		
		// Store Error / Success messages
		String passMessage = "";
		String emailMessage = "";
		
		System.out.println(formPurpose);
		System.out.println(email);
		
		if(formPurpose.equals("passUpdate")) {
			
			// verify username and password before updating password
			if(daoProxy.verifyUsernamePassword(user.getUserName(), currentPassword)) {
				
				if(daoProxy.updatePassword(user.getUserName(), newPassword)) {
					// display successfully update message
					passMessage = "Password updated!";
					System.out.println(passMessage);
				} 
				
			} else {
				// display failed to password message
				passMessage = "Password was incorrect";
				System.out.println(passMessage);
			}	
			
		} 

		if(formPurpose.equals("emailUpdate")) {
			
			
			if(daoProxy.updateEmail(user.getUserName(), email)) {
				emailMessage = "Email updated!";
				System.out.println(emailMessage);
			}
			
		}
		
		// Display html page from get request -- add passMessage and emailMessage to html page
		String page = html.getHTMLStringProfileResult(req.getServletContext().getRealPath("profile.html"), user, passMessage, emailMessage);	
		resp.getWriter().write(page);
		
	}

}
