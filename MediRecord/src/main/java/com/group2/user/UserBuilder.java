package com.group2.user;

public class UserBuilder {

	// Adding Builder Pattern to simplify user creation
	
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	
		
	public UserBuilder setUserName(String userName) {
		this.userName = userName;
		return this;
	}
	public UserBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public UserBuilder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public UserBuilder setPassword(String password) {
		this.password = password;
		return this;
	}
	public UserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}
	
	// return a User object
	public User getUser() {
		return new User(userName, firstName, lastName, password, email);
	}
	
}
