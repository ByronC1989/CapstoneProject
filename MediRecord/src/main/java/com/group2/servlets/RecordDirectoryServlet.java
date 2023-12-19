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

@WebServlet("/records")
public class RecordDirectoryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// create instances of ApplicationDAO to manage CRUD operations
	ApplicationDao dao = new ApplicationDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		// Servlet for handling Record Lists
		System.out.println("Inside RecordDirectory Servlet doGet method");
		
		// Display html page from get request
		String page = getHTMLString(req.getServletContext().getRealPath("records.html"), " ");		
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
