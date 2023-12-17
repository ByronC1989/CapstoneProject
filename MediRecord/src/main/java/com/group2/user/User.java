package com.group2.user;

import java.util.UUID;

public class User {
	// user superclass?

	// User information variables
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String email;

	// account information variables
	private UUID userID;
	private boolean verifiedUser = false; 
	// store a 0 in the database for unverified and a 1 for verified and check that to change value to true?

	
	// create role Class
	private String testRole = "Admin";
	private Role role; // set up and create role class -- handle permissions

	// default constructor
	public User() {
		this.userID = UUID.randomUUID();
	}

	public User(String userName, String firstName, String lastName, String password, String email) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;		
	}

	// GETTERS AND SETTERS FOR USER CLASS

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public UUID getUserID() {
		return userID;
	}

	public void setUserID(UUID userID) {
		this.userID = userID;
	}



	public boolean getVerifiedUser() {
		return verifiedUser;
	}

	public void setVerifiedUser(boolean verifiedUser) {
		this.verifiedUser = verifiedUser;
	}

	public String getTestRole() {
		return testRole;
	}

	public void setTestRole(String testRole) {
		this.testRole = testRole;
	}

}
