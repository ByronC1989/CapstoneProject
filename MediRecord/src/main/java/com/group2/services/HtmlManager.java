package com.group2.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import com.group2.beans.Record;

public class HtmlManager {
	
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
	
	// Display Record on HTML page
	public String getHTMLresult(String filePath, List<Record> records) throws IOException {
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
	
	// Hide Filler on HTML page
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
