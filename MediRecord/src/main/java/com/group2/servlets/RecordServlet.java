package com.group2.servlets;

import java.io.IOException;
import java.util.List;

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
	
	String message = "";
	Record record = null;
	
	// create instance of HtmlManager to write the html pages
	HtmlManager html = new HtmlManager();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Servlet for handling Record Lists
		System.out.println("Inside Record Servlet doGet method");
		
		// manage sessions informations for access
		HttpSession session = req.getSession();
		if(session.getAttribute("User")==null) {		
			
			// redirect user to login page if not logged in.
			req.setAttribute("redirect", "records");
			RequestDispatcher rd = req.getRequestDispatcher("login");
			rd.forward(req, resp);
			
			// updated to requestDispatcher
//			resp.sendRedirect("login");
		} else {
			
			if (record != null ) {
				req.setAttribute("healthCard", record.getHealthCardID());
				req.setAttribute("firstName", record.getFirstName());
				req.setAttribute("lastName", record.getLastName());
				req.setAttribute("gender", record.getGender());
				req.setAttribute("dob", record.getDateOfBirth());
				req.setAttribute("allergies", record.getAllergies());
				req.setAttribute("diagnoses", record.getDiagnoses());
			}
			
			req.setAttribute("message", message);
			req.getRequestDispatcher("/patientrecord.jsp").forward(req, resp);
			
		}
				
		// Display html page from get request
//		String page = html.getHTMLString(req.getServletContext().getRealPath("patientrecord.jsp"));	
//		resp.getWriter().write(page);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String searchString = req.getParameter("healthcard");
		
		// add health card validation --- check if health card exists in the system
		if(daoProxy.verifyRecord(searchString)) {
			
			// Might not need a List to hold records.
//			List<Record> records = daoProxy.searchRecords(searchString);
			
			record = daoProxy.selectRecord(searchString);
			
			req.setAttribute("record", record);
			message = "";
			
			System.out.println(searchString);			
//			System.out.println(records.toString());
			
			// Display html page from post request
//			String page = html.getHTMLresult(req.getServletContext().getRealPath("patientrecord.jsp"), records);	
//			resp.getWriter().write(page);
			
		} else {
			
			System.out.println("No record found!");
			message = "No record found!";
			
			// Display html page from get request
//			String page = html.getHTMLString(req.getServletContext().getRealPath("patientrecord.jsp"));	
//			resp.getWriter().write(page);
		}
		
		doGet(req, resp);		
	}
	
}
