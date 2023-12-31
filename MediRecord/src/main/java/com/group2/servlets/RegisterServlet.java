package com.group2.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group2.dao.ApplicationDao;
import com.group2.user.User;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// create instances of ApplicationDAO to manage CRUD operations
	ApplicationDao dao = new ApplicationDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Inside Register Servlet doGet!");
		
		String page = getHTMLString(req.getServletContext().getRealPath("register.html"), " ");		
		resp.getWriter().write(page);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = null;
		
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
		if(dao.verifyUsername(username) || dao.verifyEmail(email)) {
			
			// if they do exists display an error message based on which one exists
			if(dao.verifyUsername(username)) {
				
				message = "That Username already exists!";
				
			} else if(dao.verifyEmail(email)) {
				
				message = "That Email already exists!";
				
			}
			
		} else {
			
			// create user
			user = new User();
			user.setUserName(username);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setPassword(password);
			
			// Store account information inside of database
			dao.createUser(user);
			
		}
						
		
		// recreate html page inside of servlet
		String page = getHTMLString(req.getServletContext().getRealPath("register.html"), message);		
		resp.getWriter().write(page);
		
	}
	
	// Display HTML page
	public String getHTMLString(String filePath, String message) throws IOException {
		// read html page file and display the page.
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = "";
		StringBuffer buffer = new StringBuffer();
		
		while((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		
		reader.close();
		
		String page = buffer.toString();
		
		// Add content by replacing placeholder values in html page.
		page = MessageFormat.format(page, message);
		
		return page;
		
	}

}
