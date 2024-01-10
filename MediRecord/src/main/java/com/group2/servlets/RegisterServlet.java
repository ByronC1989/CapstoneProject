package com.group2.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group2.dao.DaoProxy;
import com.group2.services.ApplicationServices;
import com.group2.services.HtmlManager;
import com.group2.user.User;
import com.group2.user.UserBuilder;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// create instances of ApplicationDAO to manage CRUD operations
	//ApplicationDao dao = new ApplicationDao();  
	ApplicationServices daoProxy = new DaoProxy();	// Added proxy pattern to access DAO
	
	// create instance of HtmlManager to write the html pages
	HtmlManager html = new HtmlManager();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Inside Register Servlet doGet!");
		
		String page = html.getHTMLString(req.getServletContext().getRealPath("register.html"), " ");		
		resp.getWriter().write(page);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		User user = null;
		
		User userbuild = null;
		
		// register.html accesses register servlet doPost
		System.out.println("Inside Register Servlet doPost!");
		
		// collect form data into variables.
		String username = req.getParameter("username"); 
		String firstName = req.getParameter("firstname");
		String lastName = req.getParameter("lastname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		int verified = Integer.parseInt( req.getParameter("verifieduser")); // to be used to check if users are verified
		
		String message = "";
		
		// check if user name or email already exist in the database
		if(daoProxy.verifyUsername(username) || daoProxy.verifyEmail(email)) {
			
			// if they do exists display an error message based on which one exists
			if(daoProxy.verifyUsername(username)) {
				
				message = "That Username already exists!";
				
			} else if(daoProxy.verifyEmail(email)) {
				
				message = "That Email already exists!";
				
			}
			
		} else {
			
			// create user
			
			// No longer needed using builder pattern
//			user = new User();
//			user.setUserName(username);
//			user.setFirstName(firstName);
//			user.setLastName(lastName);
//			user.setEmail(email);
//			user.setPassword(password);
			
			userbuild = new UserBuilder().setUserName(username).setFirstName(firstName)
					.setLastName(lastName).setEmail(email).setPassword(password).getUser();
			
			// Store account information inside of database
//			dao.createUser(user);
			
			// using builder Pattern
			daoProxy.createUser(userbuild);
			
		}
						
		
		// recreate html page inside of servlet
		String page = html.getHTMLString(req.getServletContext().getRealPath("register.html"), message);		
		resp.getWriter().write(page);
		
	}
}
