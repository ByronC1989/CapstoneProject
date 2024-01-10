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
import com.group2.dao.DaoProxy;
import com.group2.services.ApplicationServices;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// create instances of ApplicationDAO to manage CRUD operations
	//ApplicationDao dao = new ApplicationDao();
	ApplicationServices daoProxy = new DaoProxy();	// Added proxy pattern to access DAO
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Inside Login Servlet doGet!");
		
		// Display html page from get request
		String page = getHTMLString(req.getServletContext().getRealPath("login.html"), " ");		
		resp.getWriter().write(page);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Inside Login Servlet doPost!");
		
		
		// collect form data into variables.
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		String message = "";
		
		// check username and password against the database
		if(daoProxy.verifyUsernamePassword(username, password)) {
			// display successfully login message
			message = "Succesfully Logged In!";
			System.out.println("Succesfully Logged In!");
		} else {
			// display failed to login message
			message = "Either your username or password are incorrect";
			System.out.println("Failed to Login!");
		}
		
		
		// Display html page from post request
		String page = getHTMLString(req.getServletContext().getRealPath("login.html"), message);		
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
