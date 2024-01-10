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



@WebServlet("/login")
public class LoginServlet extends HttpServlet {

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
		
		System.out.println("Inside Login Servlet doGet!");
		
		// Display html page from get request
		String page = html.getHTMLString(req.getServletContext().getRealPath("login.html"), " ");		
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
			
			// create session once logged in
			HttpSession session = req.getSession();
			session.setAttribute("User", username);
			
//			resp.sendRedirect("index.html"); // redirect user back to welcome page
			
		} else {
			// display failed to login message
			message = "Either your username or password are incorrect";
			System.out.println("Failed to Login!");
		}
		
		
		// Display html page from post request
		String page = html.getHTMLString(req.getServletContext().getRealPath("login.html"), message);		
		resp.getWriter().write(page);
	}
	
}
