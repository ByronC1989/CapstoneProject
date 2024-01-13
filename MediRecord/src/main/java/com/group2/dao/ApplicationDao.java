package com.group2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.group2.user.User;
import com.group2.beans.Record;
import com.group2.services.ApplicationServices;

// This Class can perform all Database CRUD Operations
public class ApplicationDao implements ApplicationServices{
	
	// Variable for holding connection 
	private Connection connection = null;
	
	public ApplicationDao() {
		// instantiate connection with the connection to database medirecord.
		this.connection = DBConnection.getConnectionToDatabase();
	}
	
	// adding user to the database.
	public void createUser(User user) {
				
		try {
			// UUID, username, first name , last name, password, email, verifieduser, role 
			String insertQuery = "INSERT INTO users VALUES(?,?,?,?,?,?,?,?)";
			
			// set parameters
			java.sql.PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, user.getUserID().toString());
			statement.setString(2, user.getUserName());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getEmail());
		    statement.setInt(7, 0); // handling verified users
			statement.setString(8, user.getTestRole() ); // replace with role
			
			// execute statement
			statement.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
	}
	
	
	// pull user from database.
	public User selectUser(String username) {
		User user = null;
		
		String sql = "SELECT * FROM users WHERE username=?";
		
		try {
			
			// set parameters
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			
			// execute statement
			ResultSet set = statement.executeQuery();
			
			// check if a match was found
			if (set.next()) {
				// create record object from database
				user = new User();
				user.setUserName(set.getString("Username"));
				user.setFirstName(set.getString("FirstName"));
				user.setLastName(set.getString("LastName"));
				user.setPassword(set.getString("Password"));
				user.setEmail(set.getString("Email"));
				//user.setVerifiedUser(set.getString("verifiedUser"));			
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	// check if a username already exists in the system.
	public boolean verifyUsername(String username) {
		boolean match = false;
		
		String sql = "SELECT * FROM users WHERE username=?";
		
		try {
			
			// set parameters
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			
			// execute statement
			ResultSet set = statement.executeQuery();
			
			// check if a match was found
			if (set.next()) {
				match = true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return match;
		
	}
	
	// check if a email already exists in the system.
	public boolean verifyEmail(String email) {
		boolean match = false;
		
		String sql = "SELECT * FROM users WHERE email=?";
		
		try {
			
			// set parameters
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			
			// execute statement
			ResultSet set = statement.executeQuery();
			
			// check if a match was found
			if (set.next()) {
				match = true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return match;
		
	}
	
	
	// check if a username and password match the database.
	public boolean verifyUsernamePassword(String username, String password) {
		boolean match = false;
		
		String sql = "SELECT * FROM users WHERE username=? AND password=?";
		
		try {
			
			// set parameters
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			
			// execute statement
			ResultSet set = statement.executeQuery();
			
			// check if a match was found
			if (set.next()) {
				match = true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return match;
		
	}
	
	// Change users password.
	public boolean updatePassword(String username, String password) {
		boolean updated = false;
		
		String sql = "UPDATE users SET password =? WHERE username =?";
		
		try {
			
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, password);
			statement.setString(2, username);
			
			// get a count of the rows affected.
			int affectedRows = statement.executeUpdate();
			
			// should only return 1 row and update the boolean value
			if(affectedRows == 1) {
				updated = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return updated;	
	}
	
	// Change user email
	public boolean updateEmail(String username, String email) {
		boolean updated = false;
		
		String sql = "UPDATE users SET email =? WHERE username =?";
		
		try {
			
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, username);
			
			// get a count of the rows affected.
			int affectedRows = statement.executeUpdate();
			
			// should only return 1 row and update the boolean value
			if(affectedRows == 1) {
				updated = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return updated;	
	}
	
	
	
	// adding patient record to the database.
	public void createPost(Record record) {
				
		try {
			// healthcard#, firstname, lastname, gender, dateOfBirth, creationDate, allergies, Diagnoses
			String insertQuery = "INSERT INTO records VALUES(?,?,?,?,?,?,?,?)";
			
			// set parameters
			java.sql.PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, record.getHealthCardID());
		    statement.setString(2, record.getFirstName());
			statement.setString(3, record.getLastName());
			statement.setString(4, record.getGender());
			statement.setString(5, record.getDateOfBirth());
			statement.setDate(6, record.getCreateDate());
		    statement.setString(7, record.getAllergies());
			statement.setString(8, record.getDiagnoses()); 
			
			// execute statement
			statement.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
	}
	
	// search for patient records to be displayed
	public List<Record> searchRecords(String search){
		Record record = null;
		List<Record> records = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM records WHERE HealthcardID=" + search;
			
			Statement statement = connection.createStatement();
			
			statement.executeQuery(sql);
			
			ResultSet set = statement.executeQuery(sql);
			
			
			while(set.next()) {
				// create record object from database
				record = new Record();
				record.setHealthCardID(set.getString("HealthcardID"));
				record.setFirstName(set.getString("FirstName"));
				record.setLastName(set.getString("LastName"));
				record.setGender(set.getString("Gender"));
				record.setDateOfBirth(set.getString("DateOfBirth"));
				record.setAllergies(set.getString("Allergies"));
				record.setDiagnoses(set.getString("Diagnoses"));
				
				// add records to arraylist
				records.add(record);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}

		
		return records;
		
	}
	
	// check if a record exists in the system.
	public boolean verifyRecord(String healthCardID) {
		boolean match = false;
		
		String sql = "SELECT * FROM records WHERE HealthcardID=?";
		
		try {
			
			// set parameters
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, healthCardID);
			
			// execute statement
			ResultSet set = statement.executeQuery();
			
			// check if a match was found
			if (set.next()) {
				match = true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return match;
		
	}

}
