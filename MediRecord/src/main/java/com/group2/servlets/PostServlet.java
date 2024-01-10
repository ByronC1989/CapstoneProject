package com.group2.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group2.beans.Record;
import com.group2.beans.RecordBuilder;
import com.group2.dao.ApplicationDao;
import com.group2.dao.DaoProxy;
import com.group2.services.ApplicationServices;

@WebServlet("/post")
public class PostServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// create instances of ApplicationDAO to manage CRUD operations
	//ApplicationDao dao = new ApplicationDao();
	ApplicationServices daoProxy = new DaoProxy();	// Added proxy pattern to access DAO
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Servlet for handling Posting Records
		System.out.println("Inside Post Servlet doGet method");
		
		// Display html page from get request
		String page = getHTMLString(req.getServletContext().getRealPath("post.html"), " ");		
		resp.getWriter().write(page);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// collect data from form
		String healthCard = req.getParameter("healthcard");
		String firstName = req.getParameter("firstname");
		String lastName = req.getParameter("lastname");
		String gender = req.getParameter("gender");
		String dateOfBirth = req.getParameter("dateofbirth");
		String allergies = req.getParameter("allergies");
		String diagnoses = req.getParameter("diagnoses");
		
		// message to be displayed on success or error
		String message = "Success!";
		
		// add health card validation --- check if health card already exists in the system
		
		// create a creation date
		long currentTime = System.currentTimeMillis();
		Date createDate = new Date(currentTime);
		
		// create record object from form data
		//Record record = new Record(healthCard, firstName, lastName, gender, dateOfBirth, allergies, diagnoses, createDate);
		
		Record record = new RecordBuilder().setHealthCardID(healthCard).setFirstName(firstName).setLastName(lastName).setGender(gender)
				.setDateOfBirth(dateOfBirth).setAllergies(allergies).setDiagnoses(diagnoses).setCreateDate(createDate).getRecord();
		
		// add record to database
		//dao.createPost(record);
		daoProxy.createPost(record);
		
		
		// Display html page from post request
		String page = getHTMLString(req.getServletContext().getRealPath("post.html"), message);		
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
