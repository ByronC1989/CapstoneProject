package com.group2.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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



@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// create instances of ApplicationDAO to manage CRUD operations
	//ApplicationDao dao = new ApplicationDao();
	ApplicationServices daoProxy = new DaoProxy();	// Added proxy pattern to access DAO
	
	String redirection = "";
	
	// create instance of HtmlManager to write the html pages
	HtmlManager html = new HtmlManager();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Inside Login Servlet doGet!");
		String message= "";
		
		// no longer needed when using JSP
		// Display html page from get request
//		String page = html.getHTMLString(req.getServletContext().getRealPath("login.html"), " ");		
//		resp.getWriter().write(page);
		;
		redirection = (String) req.getAttribute("redirect");
		
		req.setAttribute("message", message);
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
		
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
			
			// create user object to pass information around
			User user = daoProxy.selectUser(username);
						
			// create session once logged in
			HttpSession session = req.getSession();
			session.setAttribute("User", user);
			
//			resp.sendRedirect("index.html"); // redirect user back to welcome page
			
		} else {
			// display failed to login message
			message = "Either your username or password are incorrect";
			System.out.println("Failed to Login!");
		}
		
		if(redirection == null) {
			
			// no longer needed when using JSP
			// Display html page from post request
//			String page = html.getHTMLString(req.getServletContext().getRealPath("login.html"), message);		
//			resp.getWriter().write(page);
			
			req.setAttribute("message", message);
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			
		} else if(redirection.equals("post")) {
			
			RequestDispatcher rd = req.getRequestDispatcher("post");
			rd.forward(req, resp);
			
		} else if(redirection.equals("records")) {
			
			RequestDispatcher rd = req.getRequestDispatcher("records");
			rd.forward(req, resp);
			
			
		}
		

	}
	
}
