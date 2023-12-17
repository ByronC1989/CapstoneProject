package com.group2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.group2.user.User;

// This Class can perform all Database CRUD Operations
public class ApplicationDao {
	
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
	
	
	// adding user to the database.
	public void createPost(Record record) {
				
		try {
			// UUID, username, first name , last name, password, email, verifieduser, role 
			String insertQuery = "INSERT INTO records VALUES(?,?,?,?,?,?,?,?)";
			
			// set parameters
			java.sql.PreparedStatement statement = connection.prepareStatement(insertQuery);
			//statement.setString(1, user.getUserID().toString());
			//statement.setString(2, user.getUserName());
			//statement.setString(3, user.getFirstName());
			//statement.setString(4, user.getLastName());
			//statement.setString(5, user.getPassword());
			//statement.setString(6, user.getEmail());
		   // statement.setInt(7, 0); // handling verified users
			//statement.setString(8, user.getTestRole() ); // replace with role
			
			// execute statement
			statement.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
	}

}
