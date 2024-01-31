package com.group2.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group2.beans.Record;
import com.group2.beans.RecordBuilder;
import com.group2.dao.DaoProxy;
import com.group2.services.ApplicationServices;
import com.group2.services.HtmlManager;

@WebServlet("/post")
public class PostServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// create instances of ApplicationDAO to manage CRUD operations
	//ApplicationDao dao = new ApplicationDao();
	ApplicationServices daoProxy = new DaoProxy();	// Added proxy pattern to access DAO
	
	// create instance of HtmlManager to write the html pages
	HtmlManager html = new HtmlManager();
	
	String message= " ";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// manage sessions informations for access
		HttpSession session = req.getSession();
		if(session.getAttribute("User")==null) {
			resp.sendRedirect("login");
		} else {
			
			// Servlet for handling Posting Records
			System.out.println("Inside Post Servlet doGet method");
			
			// no longer needed when using JSP
			// Display html page from get request
//			String page = html.getHTMLString(req.getServletContext().getRealPath("post.html"), " ");		
//			resp.getWriter().write(page);
			
			req.setAttribute("message", message);
			req.getRequestDispatcher("/post.jsp").forward(req, resp);
			
		}
		
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
		
		// add health card validation --- check if health card already exists in the system
		if(!daoProxy.verifyRecord(healthCard)) {
			message = "Success!";
			
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
			
			
		} else {
			message = "Health Card already exists";
		}
		
		// no longer needed when using JSP
		// Display html page from post request
//		String page = html.getHTMLString(req.getServletContext().getRealPath("post.html"), message);		
//		resp.getWriter().write(page);
			
				
		doGet(req, resp);
	}
}
