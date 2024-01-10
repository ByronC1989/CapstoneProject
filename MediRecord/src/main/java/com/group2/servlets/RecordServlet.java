package com.group2.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group2.dao.DaoProxy;
import com.group2.services.ApplicationServices;
import com.group2.services.HtmlManager;
import com.group2.beans.Record;

@WebServlet("/records")
public class RecordServlet extends HttpServlet{

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
		
		// Servlet for handling Record Lists
		System.out.println("Inside Record Servlet doGet method");
		
		// manage sessions informations for access
		HttpSession session = req.getSession();
		if(session.getAttribute("User")==null) {
			resp.sendRedirect("login");
		}
				
		// Display html page from get request
		String page = html.getHTMLString(req.getServletContext().getRealPath("patientrecord.html"));	
		resp.getWriter().write(page);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String searchString = req.getParameter("healthcard");
		
		// add health card validation --- check if health card exists in the system
		
		// Might not need a List to hold records.
		List<Record> records = daoProxy.searchRecords(searchString);		
		
		System.out.println(searchString);
		
		System.out.println(records.toString());
		
		
		// Display html page from post request
		String page = html.getHTMLresult(req.getServletContext().getRealPath("patientrecord.html"), records);	
		resp.getWriter().write(page);
		
	}
}
