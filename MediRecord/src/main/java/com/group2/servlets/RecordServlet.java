package com.group2.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group2.dao.ApplicationDao;
import com.group2.beans.Record;

@WebServlet("/records")
public class RecordServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// create instances of ApplicationDAO to manage CRUD operations
	ApplicationDao dao = new ApplicationDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Servlet for handling Record Lists
		System.out.println("Inside Record Servlet doGet method");
		
		// add search bar to display record on page --- remove directory page
		
		// Display html page from get request
		String page = getHTMLString(req.getServletContext().getRealPath("patientrecord.html"));	
		resp.getWriter().write(page);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String searchString = req.getParameter("healthcard");
		// Might not need a List to hold records.
		List<Record> records = dao.searchRecords(searchString);		
		
		System.out.println(searchString);
		
		System.out.println(records.toString());
		
		// Display html page from get request
		//String page = getHTMLString(req.getServletContext().getRealPath("patientrecord.html"));	
		//resp.getWriter().write(page);
		
		
		// Display html page from get request
		String page = getHTMLresult(req.getServletContext().getRealPath("patientrecord.html"), records);	
		resp.getWriter().write(page);
		
	}
	
	private String getHTMLresult(String filePath, List<Record> records) throws IOException {
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
		// Add loop for List display
		page = MessageFormat.format(page, records.get(0).getHealthCardID(), records.get(0).getFirstName(), 
				records.get(0).getLastName(), records.get(0).getGender(), records.get(0).getDateOfBirth(),
				records.get(0).getAllergies(), records.get(0).getDiagnoses());
		
		return page;
	}


	// Display HTML page
	public String getHTMLString(String filePath) throws IOException {
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
		page = MessageFormat.format(page, " ", " ", " ", " "," "," "," ");
		
		return page;
		
	}
	


}
